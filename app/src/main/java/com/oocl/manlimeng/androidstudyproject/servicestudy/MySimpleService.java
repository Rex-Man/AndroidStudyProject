package com.oocl.manlimeng.androidstudyproject.servicestudy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;


/**
 * Created by manre on 8/28/16.
 */
public class MySimpleService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("----------------------------onBind");
        return null;
    }

    @Override
    public void onCreate() {
        System.out.println("----------------------------oncreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("----------------------------onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        System.out.println("----------------------------onDestroy");
        super.onDestroy();
    }
}
