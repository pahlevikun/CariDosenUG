package com.ctproject.caridosenug;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        boolean pertamaJalan = getSharedPreferences("JALAN",MODE_PRIVATE).getBoolean("pertamajalan",true);
        if(pertamaJalan){
            Intent intent = new Intent(SplashActivity.this, TutorPertamaActivity.class);
            SplashActivity.this.startActivity(intent);
            SplashActivity.this.finish();

            getSharedPreferences("JALAN",MODE_PRIVATE)
                    .edit()
                    .putBoolean("pertamajalan",false)
                    .commit();
        }
        else{
            StartAnimations();
        }
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        int SPLASH_TIME_OUT = 3500;

        anim.reset();
        ImageView imageView = (ImageView) findViewById(R.id.logo);
        imageView.clearAnimation();
        imageView.startAnimation(anim);

        new Handler().postDelayed(new Thread() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
                overridePendingTransition(R.anim.alphain, R.anim.alphaout);
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void onBackPressed() {

    }

}