package com.example.seonghoon.yeodam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

/**
 * Created by Seonghoon on 2015-11-05.
 */


//Splash

public class SpalshActivity extends Activity {


    Handler h;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //타이틀바 없애기
        setContentView(R.layout.splash);
        h = new Handler();
        h.postDelayed(irun,4000);   //1.5초 띄워주기

    }

    Runnable irun = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(SpalshActivity.this, MainActivity.class);
            startActivity(i);
            finish();

            //fade in 시작, fade out 종료
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        }
    };



    //뒤로가기 눌렀을때 꺼지지 않도록
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        h.removeCallbacks(irun);
    }
}
