package com.ctproject.caridosenug;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by farhan on 2/29/16.
 */
public class DosenDetailActivity extends AppCompatActivity {
    //mendefinisikan
    private TextView textViewID;
    private TextView textViewJabatan;
    private TextView textViewMatkul;
    private TextView textViewNama;
    private TextView textViewSitus;
    private TextView textViewEmail;
    private TextView textViewKantor;
    private TextView textViewTelepon;
    private ImageView imageViewFoto;

    private FloatingActionButton floatingActionButton;

    private LinearLayout linLayJabatan;
    private LinearLayout linLayMatkul;
    private LinearLayout linLaySitus;
    private LinearLayout linLayEmail;
    private LinearLayout linLayAlamatKantor;
    private LinearLayout linLayTelepon;
    private CoordinatorLayout coordinatorLayoutFAB;

    private ClipboardManager clipboardManager;
    private ClipData clipData;

    private String namaDosen;
    private String bantu;
    private String Dosen;
    private String Jabatan;
    private String Matkul;
    private String Situs;
    private String Email;
    private String Alamat;
    private String Telepon;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_detail);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        coordinatorLayoutFAB = (CoordinatorLayout) findViewById(R.id.coordinatorFAB);

        clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);

        //inisialisasi
        //textViewID = (TextView) findViewById(R.id.tvID);
        textViewNama = (TextView) findViewById(R.id.tvNamaDetail);
        textViewJabatan = (TextView) findViewById(R.id.tvJabatan);
        textViewMatkul = (TextView) findViewById(R.id.tvMatkul);
        textViewSitus = (TextView) findViewById(R.id.tvSitus);
        textViewEmail = (TextView) findViewById(R.id.tvEmail);
        textViewKantor = (TextView) findViewById(R.id.tvAlamat);
        textViewTelepon = (TextView) findViewById(R.id.tvTelepon);
        imageViewFoto = (ImageView) findViewById(R.id.ivDetailDosen);
        linLayEmail = (LinearLayout) findViewById(R.id.linearLayoutEmail);
        linLayJabatan = (LinearLayout) findViewById(R.id.linearLayoutJabatan);
        linLayAlamatKantor = (LinearLayout) findViewById(R.id.linearLayoutAlamatKantor);
        linLayMatkul = (LinearLayout) findViewById(R.id.linearLayoutMatkul);
        linLaySitus = (LinearLayout) findViewById(R.id.linearLayoutSitus);
        linLayTelepon = (LinearLayout) findViewById(R.id.linearLayoutTelepon);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        //mengambil intent
        Intent intent = getIntent();

        //Menampilkan nilai hasil parsing dari intent
        textViewNama.setText(intent.getStringExtra(DosenActivity.NAMA));
        if(intent.getStringExtra(DosenActivity.JABATAN)==null){
            textViewJabatan.setText("-");
        }
        else{
            textViewJabatan.setText(intent.getStringExtra(DosenActivity.JABATAN));
        }
        if(intent.getStringExtra(DosenActivity.MATKUL)==null){
            textViewMatkul.setText("-");
        }
        else{
            textViewMatkul.setText(intent.getStringExtra(DosenActivity.MATKUL));
        }
        if(intent.getStringExtra(DosenActivity.SITUS)==null){
            textViewSitus.setText("-");
        }
        else{
            textViewSitus.setText(intent.getStringExtra(DosenActivity.SITUS));
        }
        textViewEmail.setText(intent.getStringExtra(DosenActivity.EMAIL));
        if(intent.getStringExtra(DosenActivity.KANTOR)==null){
            textViewKantor.setText("-");
        }
        else{
            textViewKantor.setText(intent.getStringExtra(DosenActivity.KANTOR));
        }
        if(intent.getStringExtra(DosenActivity.TELEPON)==null) {
            textViewTelepon.setText("-");
        }
        else{
            textViewTelepon.setText(intent.getStringExtra(DosenActivity.TELEPON));
        }
        if(intent.getStringExtra(DosenActivity.FOTO)==null){
            imageViewFoto.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_noimage));
        }
        else {
            Picasso.with(this).load(intent.getStringExtra(DosenActivity.FOTO)).into(imageViewFoto);
        }

        //Menekan Liniear Layout
        linLayJabatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = getIntent();
                if(intent.getStringExtra(DosenActivity.JABATAN)==null){
                    Toast.makeText(DosenDetailActivity.this,"Tidak ada data!", Toast.LENGTH_SHORT).show();
                }
                else {
                    namaDosen = textViewNama.getText().toString();
                    bantu = intent.getStringExtra(DosenActivity.JABATAN);
                    clipData = ClipData.newPlainText("text", "Jabatan Bpk/Ibu " + namaDosen + ", adalah " + bantu);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(DosenDetailActivity.this,"Jabatan Dosen berhasil disalin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        linLayEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = getIntent();
                if(intent.getStringExtra(DosenActivity.EMAIL)==null){
                    Toast.makeText(DosenDetailActivity.this,"Tidak ada data!", Toast.LENGTH_SHORT).show();
                }
                else {
                    namaDosen = textViewNama.getText().toString();
                    bantu = intent.getStringExtra(DosenActivity.EMAIL);
                    clipData = ClipData.newPlainText("text", "Email Bpk/Ibu " + namaDosen + ", adalah " + bantu);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(DosenDetailActivity.this,"Email Dosen berhasil disalin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        linLayAlamatKantor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = getIntent();
                if(intent.getStringExtra(DosenActivity.KANTOR)==null){
                    Toast.makeText(DosenDetailActivity.this,"Tidak ada data!", Toast.LENGTH_SHORT).show();
                }
                else {
                    namaDosen = textViewNama.getText().toString();
                    bantu = intent.getStringExtra(DosenActivity.KANTOR);
                    clipData = ClipData.newPlainText("text", "Kantor Bpk/Ibu " + namaDosen + ", berada di  " + bantu);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(DosenDetailActivity.this,"Alamat Kantor Dosen berhasil disalin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        linLayMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = getIntent();
                if(intent.getStringExtra(DosenActivity.MATKUL)==null){
                    Toast.makeText(DosenDetailActivity.this,"Tidak ada data!", Toast.LENGTH_SHORT).show();
                }
                else {
                    namaDosen = textViewNama.getText().toString();
                    bantu = intent.getStringExtra(DosenActivity.MATKUL);
                    clipData = ClipData.newPlainText("text", "Matkul yang diajar Bpk/Ibu " + namaDosen + ", adalah " + bantu);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(DosenDetailActivity.this,"Matkul Dosen berhasil disalin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        linLaySitus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = getIntent();
                if(intent.getStringExtra(DosenActivity.SITUS)==null){
                    Toast.makeText(DosenDetailActivity.this,"Tidak ada data!", Toast.LENGTH_SHORT).show();
                }
                else {
                    namaDosen = textViewNama.getText().toString();
                    bantu = intent.getStringExtra(DosenActivity.SITUS);
                    clipData = ClipData.newPlainText("text", "Situs web Bpk/Ibu " + namaDosen + ", adalah " + bantu);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(DosenDetailActivity.this,"Situs Dosen berhasil disalin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        linLayTelepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = getIntent();
                if(intent.getStringExtra(DosenActivity.TELEPON)==null){
                    Toast.makeText(DosenDetailActivity.this,"Tidak ada data!", Toast.LENGTH_SHORT).show();
                }
                else {
                    namaDosen = textViewNama.getText().toString();
                    bantu = intent.getStringExtra(DosenActivity.TELEPON);
                    clipData = ClipData.newPlainText("text", "No. Telp Bpk/Ibu " + namaDosen + ", adalah " + bantu);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(DosenDetailActivity.this,"Telepon Dosen berhasil disalin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                Dosen = intent.getStringExtra(DosenActivity.NAMA);
                Jabatan = intent.getStringExtra(DosenActivity.JABATAN);
                if(Jabatan==null){
                    Jabatan = "-";
                }
                Matkul = intent.getStringExtra(DosenActivity.MATKUL);
                if(Matkul==null){
                    Matkul = "-";
                }
                Situs = intent.getStringExtra(DosenActivity.SITUS);
                if(Situs==null){
                    Situs = "-";
                }
                Email = intent.getStringExtra(DosenActivity.EMAIL);
                if(Email==null){
                    Email = "-";
                }
                Alamat = intent.getStringExtra(DosenActivity.KANTOR);
                if(Alamat==null){
                    Alamat = "-";
                }
                Telepon = intent.getStringExtra(DosenActivity.TELEPON);
                if(Telepon==null){
                    Telepon = "-";
                }

                clipData = ClipData.newPlainText("text", "Bpk/Ibu "+Dosen+
                        "\nMenjabat sebagai : "+Jabatan+
                        "\nMengajar Matkul : "+Matkul+
                        "\nSitus staffsite : "+Situs+
                        "\nEmail Dosen : "+Email+
                        "\nAlamat Ruang Dosen : "+Alamat+
                        "\nNo. Telp : "+Telepon+"");
                clipboardManager.setPrimaryClip(clipData);

                Snackbar snackbar = Snackbar
                        .make(coordinatorLayoutFAB, "Berhasil disalin ke clipboard." +
                                "\nIngin bagikan ke Aplikasi lain?", Snackbar.LENGTH_LONG)
                        .setDuration(5000)
                        .setAction("Bagikan", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent Bagikan = new Intent(Intent.ACTION_SEND);
                                Bagikan.setType("text/plain");
                                Bagikan.putExtra(Intent.EXTRA_TEXT, "Bpk/Ibu " + Dosen +
                                        "\nMenjabat sebagai : " + Jabatan +
                                        "\nMengajar Matkul : " + Matkul +
                                        "\nSitus staffsite : " + Situs +
                                        "\nEmail Dosen : " + Email +
                                        "\nAlamat Ruang Dosen : " + Alamat +
                                        "\nNo. Telp : " + Telepon + "");
                                startActivity(Intent.createChooser(Bagikan, "Bagikan Data Dosen melalui:"));
                            }
                        });
                snackbar.setActionTextColor(Color.WHITE);
                // Snackbar Action button text color
                View snackBarView = snackbar.getView();
                TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.WHITE);
                snackbar.show();
            }
        });
    }

    //
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bantuan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_bantuan:
                Intent intentBantuan = new Intent(DosenDetailActivity.this, BantuanActivity.class);
                startActivity(intentBantuan);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}