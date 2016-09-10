package com.oocl.manlimeng.androidstudyproject.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by manlimeng on 16/9/10.
 */
public class OrderBroadcastReceiver1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=getResultExtras(true);
        String first=bundle.getString("first");
        Toast.makeText(context,"the first broadcast message is:"+ first,Toast.LENGTH_SHORT).show();
    }
}
