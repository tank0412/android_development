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
    public static int minutes;
    public static int hours;
    public static boolean runnning = true;
    public static Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seconds = 0;
        minutes = 0;
        hours = 0;
        Log.i("Main", "Run app");
    }

    public void onClickStart(View view) {
        Log.i("Main", "onClickStart");
        runnning = true;
        checkTimer();

    }

    public void onClickStop(View view) {
        runnning = false;

    }

    public void onClickReset(View view) {
        runnning = true;
        seconds = 0;
        checkTimer(); // работает и так

    }
    public void runTimer() {
        Log.i("Main", "runTimer()");
        String timer = "";
        if(MainActivity.hours < 10) {
            timer+="0";
        }
        timer+= hours;
        timer+=":";

        if(MainActivity.minutes < 10) {
            timer+="0";
        }
        timer+= minutes;
        timer+=":";

        if(MainActivity.seconds < 10) {
            timer+="0";
        }
        if(MainActivity.seconds >= 60) {
            minutes++;
            timer+="0";
            seconds= 0;
            return; // fix this
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
                    if (MainActivity.runnning) { // мини-костыль пофиксить позже
                        Log.i("Main", "run()");
                        runTimer();
                        mHandler.postDelayed(this, 1000);
                    }
                }
            };

            mHandler.postDelayed(r, 1000);
        } else {
            //Log.i("Main", "Continue for " + MainActivity.runnning);
        }
    }

}
