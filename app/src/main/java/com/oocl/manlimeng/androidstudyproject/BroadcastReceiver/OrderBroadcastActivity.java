package com.oocl.manlimeng.androidstudyproject.BroadcastReceiver;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.oocl.manlimeng.androidstudyproject.R;

public class OrderBroadcastActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_broadcast);
    }
    public void sendOrderedBroadcast(View view)
    {
        Intent intent1=getIntent();
        Intent intent=new Intent();
        intent.setAction("com.oocl.manlimeng.broadcast.SEND_ORDER_BROADCAST");
        Bundle bundle=new Bundle();
        bundle.putString("msg",intent1.getStringExtra("title"));
        intent.putExtras(bundle);
        sendOrderedBroadcast(intent,null);
    }
}
