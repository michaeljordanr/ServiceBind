package com.example.michael.service;


import android.os.SystemClock;
import android.util.Log;

public class TimeWorker implements Runnable {

    public static final String TAG = "APP";

    private volatile boolean running;
    private int seconds;

    @Override
    public void run() {
        running = true;

        while(running){
            incrementSeconds();
            Log.i(TAG, "Segundos = " + seconds);
            SystemClock.sleep(1000);
        }
    }

    public void stop(){
        running = false;
    }

    private synchronized void incrementSeconds(){
        seconds++;
    }

    public int getSeconds() {
        return seconds;
    }
}
