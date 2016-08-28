package com.oocl.manlimeng.androidstudyproject.servicestudy;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by manre on 8/28/16.
 */
public class MyBindService extends Service {

    private int count;
    private MyBinder myBinder=new MyBinder();
    String city="";

    public class MyBinder extends Binder
    {
        public void showMessage(int message)
        {
            count=message;
        }
        public int getCount()
        {
            return count;
        }
        public MyBindService getService()
        {
            return MyBindService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Bundle bundle= intent.getExtras();
        String resultCity= (String) bundle.get("city");
        city=resultCity;
        System.out.println("onBind function:--------"+resultCity);
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("==================onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        System.out.println("==================onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        System.out.println("==================onDestroy");
        super.onDestroy();
    }

    public String testFunctionInService()
    {
        return city;
    }
}
