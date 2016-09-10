package com.oocl.manlimeng.androidstudyproject.BroadcastReceiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by manlimeng on 16/9/10.
 */
public class TransforService extends Service{
    int saveValue=1;

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.oocl.manlimeng.action.ACTIVITYTOSERVER");
        registerReceiver(new ActivityToServiceReceiver(),intentFilter);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public class ActivityToServiceReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getIntExtra("saveValue",0)==saveValue)
            {
                Intent intentSendToActivity=new Intent();
                intentSendToActivity.setAction("com.oocl.manlimeng.action.SERVERTOACTIVITY");
                intentSendToActivity.putExtra("backMsg","Back_"+intent.getIntExtra("saveValue",0));
                saveValue=intent.getIntExtra("saveValue",0)+1;
                sendBroadcast(intentSendToActivity);
            }else{
                Intent intentSendToActivity=new Intent();
                intentSendToActivity.setAction("com.oocl.manlimeng.action.SERVERTOACTIVITY");
                intentSendToActivity.putExtra("backMsg","not match need to put:"+saveValue);
                sendBroadcast(intentSendToActivity);
            }
        }
    }


}
