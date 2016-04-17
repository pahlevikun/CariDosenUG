package com.ctproject.caridosenug;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import java.security.PrivateKey;

/**
 * Created by farhan on 3/2/16.
 */
public class TambahDosenActivity extends AppCompatActivity {

    private WebView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahdosen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        String url = "https://goo.gl/forms/H56oh7P6fF";  //Pendefinisian URL
        view = (WebView) this.findViewById(R.id.webView);  //sinkronisasi object berdasarkan id
        view.getSettings().setJavaScriptEnabled(true);  //untuk mengaktifkan javascript
        view.setWebViewClient(new AntiPindahKeBrowser());//Agar tidak pindah ke browser override method
        view.loadUrl(url);   //agar URL terload saat dibuka aplikasi
        view.getSettings().setBuiltInZoomControls(true);//zoom
        view.getSettings().setSupportZoom(true);//zoom

        //Untuk membuat progress bar
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                Window.PROGRESS_VISIBILITY_ON);
        //Mengubah nama titlebar
        view.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                TambahDosenActivity.this.setTitle("Sedang Memuat...");
                TambahDosenActivity.this.setProgress(progress * 100);
                if (progress == 100){
                    TambahDosenActivity.this.setTitle("Tambah Data Dosen");
                }
            }
        });
    }

    //kelas untuk membuat webview tidak direct ke browser
    private class AntiPindahKeBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //ketika disentuh tombol back
        if ((keyCode == KeyEvent.KEYCODE_BACK) && view.canGoBack()) {
            view.goBack(); //method goback() dieksekusi untuk kembali pada halaman sebelumnya
            return true;
        }
        // Jika tidak ada history (Halaman yang sebelumnya dibuka)
        // maka akan keluar dari activity
        return super.onKeyDown(keyCode, event);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bantuan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_bantuan:
                AlertDialog.Builder penuh = new AlertDialog.Builder(this);
                penuh
                        .setTitle("Bantuan")
                        .setMessage("Halaman ini akan membuka sebuah website yang dapat digunakan untuk menambah data Dosen," +
                                " silahkan isi kolom yang tersedia, tim kami akan mengecek dan memasukan data kedalam database.")
                        .setPositiveButton("Ya", null)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
