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
        Log.i("Main", "Run app");
        checkBundle(savedInstanceState);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putInt("minutes", minutes);
        savedInstanceState.putInt("hours", hours);
        savedInstanceState.putBoolean("runnning", runnning);
        super.onSaveInstanceState(savedInstanceState);
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
        runnning = false;
        seconds = 0;
        minutes = 0;
        hours = 0;
        runnning = true;
        //checkTimer(); // работает и так

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

    public void checkBundle(Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            if (!savedInstanceState.containsKey("seconds")) {

            } else {
                seconds = savedInstanceState.getInt("seconds");
            }
            if (!savedInstanceState.containsKey("minutes")) {

            } else {
                seconds = savedInstanceState.getInt("minutes");
            }
            if (!savedInstanceState.containsKey("hours")) {

            } else {
                seconds = savedInstanceState.getInt("hours");
            }
        }
        else {
            seconds = 0;
            minutes = 0;
            hours = 0;
        }
    }

}
