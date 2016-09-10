package com.oocl.manlimeng.androidstudyproject.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by manlimeng on 16/9/10.
 */
public class OrderBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"接收到的Intent的Action为: "+intent.getAction()+"\n 消息内容是:"+ intent.getStringExtra("msg"),Toast.LENGTH_LONG).show();
        Bundle bundle=new Bundle();
        bundle.putString("first","first broadcastReceiver message");
        setResultExtras(bundle);
        //
        //abortBroadcast();
    }
}
