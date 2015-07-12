package com.example.michael.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class TimeService extends Service {

    private TimeWorker worker;
    private TimeServiceBinder binder = new TimeServiceBinder();

    @Override
    public void onCreate() {
        super.onCreate();

        worker = new TimeWorker();

        Log.i(TimeWorker.TAG, "Servico criado!");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(worker).start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        worker.stop();
    }

    public int getSeconds(){
        return worker.getSeconds();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class TimeServiceBinder extends Binder{
        public TimeService getService(){
            return TimeService.this;
        }
    }
}
