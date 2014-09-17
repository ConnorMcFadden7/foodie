package com.connormcfadden.foodie.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.connormcfadden.foodie.R;
import android.os.Handler;

public class SplashScreenActivity extends Activity {
    private static int KEY_SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, KEY_SPLASH_TIME_OUT);
    }
}

