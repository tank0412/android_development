package com.example.lab41ad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int seconds;
    public static boolean runnning = true;
    public static Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seconds = 0;
        Log.i("Main", "Run app");
    }

    public void onClickStart(View view) {
        Log.i("Main", "onClickStart");
        runnning = true;
        //Intent intent = new Intent(this, MyIntentService.class);
        //startService(intent);
        checkTimer();

    }

    public void onClickStop(View view) {
        runnning = false;

    }

    public void onClickReset(View view) {
        runnning = false;
        seconds = 0;

    }
    public void runTimer() {
        Log.i("Main", "runTimer()");
        String timer = "00:00:";
        if(MainActivity.seconds < 10) {
            timer+="0";
        }
        timer += String.valueOf(MainActivity.seconds);
        //TextView textView = findViewById(R.id.time);
        //textView.setText(timer);
        TextView textView = findViewById(R.id.time);
        textView.setText(timer);
        MainActivity.seconds++;
        Log.i("Main", String.valueOf(MainActivity.seconds));
    }

    public void checkTimer() {
        Log.i("Main", "Before for " + MainActivity.runnning);
        if (MainActivity.runnning) {
            Log.i("Main", "Wow " + MainActivity.runnning);
            final Handler mHandler = new Handler(getMainLooper());

            final Runnable r = new Runnable() {
                public void run() {
                    Log.i("Main", "run()");
                    runTimer();
                    mHandler.postDelayed(this, 1000);
                }
            };

            mHandler.postDelayed(r, 1000);
        } else {
            //Log.i("Main", "Continue for " + MainActivity.runnning);
        }
    }

}
