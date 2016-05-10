package com.jspiders.omg;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.jspiders.omg.activity.LoginActivity;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 50;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);

        setContentView(R.layout.activity_splash_screen);
        iv = (ImageView)findViewById(R.id.imageView2);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        Animation animation1 = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.zoom_enter);
        iv.startAnimation(animation1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
