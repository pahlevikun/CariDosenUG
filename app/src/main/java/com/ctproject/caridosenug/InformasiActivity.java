package com.ctproject.caridosenug;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by farhan on 3/2/16.
 */
public class InformasiActivity extends AppCompatActivity implements View.OnClickListener {

    public LinearLayout TentangAplikasi, Bantuan, Saran, TentangKami, HakCipta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        TentangAplikasi = (LinearLayout) findViewById(R.id.tentang_aplikasi);
        Bantuan = (LinearLayout) findViewById(R.id.bantuan);
        Saran = (LinearLayout) findViewById(R.id.kritik_saran);
        TentangKami = (LinearLayout) findViewById(R.id.tentang);
        HakCipta = (LinearLayout) findViewById(R.id.hakcipta);

        TentangAplikasi.setOnClickListener(this);
        Bantuan.setOnClickListener(this);
        Saran.setOnClickListener(this);
        TentangKami.setOnClickListener(this);
        HakCipta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tentang_aplikasi:
                Intent intentAplikasi = new Intent(InformasiActivity.this, TentangAplikasiActivity.class);
                startActivity(intentAplikasi);
                break;
            case R.id.bantuan:
                Intent intentBantuan = new Intent(InformasiActivity.this, BantuanActivity.class);
                startActivity(intentBantuan);
                break;
            case R.id.kritik_saran:
                /*
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("message/rfc822");
                Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "pahlevi.kun@gmail.com" });
                Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback Cari Dosen UG");
                Email.putExtra(Intent.EXTRA_TEXT, "[Pesan, Kritik & Saran] ");
                try {
                startActivity(Intent.createChooser(Email, "Kirim Saran:"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(InformasiActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                */
                Intent Email = new Intent(Intent.ACTION_VIEW);
                Email.setType("plain/text");
                Email.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                Email.setData(Uri.parse("pahlevi.kun@gmail.com"));
                Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "pahlevi.kun@gmail.com" });
                Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback Aplikasi Cari Dosen UG");
                Email.putExtra(Intent.EXTRA_TEXT, "[Pesan, Kritik & Saran]\n");
                try {
                    startActivity(Email);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(InformasiActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tentang:
                Intent intentKami = new Intent(InformasiActivity.this, TentangKamiActivity.class);
                startActivity(intentKami);
                break;
            case R.id.hakcipta:
                Intent intentHak = new Intent(InformasiActivity.this, HakCiptaActivity.class);
                startActivity(intentHak);
                break;
        }

    }
}
