package com.oocl.manlimeng.androidstudyproject.BroadcastReceiver;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.oocl.manlimeng.androidstudyproject.R;

public class NormalBroadcastActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_broadcast);
    }
    public void sendBroadcast(View view)
    {
        Intent intent1=getIntent();
        Intent intent=new Intent();
        intent.setAction("com.oocl.manlimeng.action.SEND_NORMAL_BROADCAST");
        Bundle bundle=new Bundle();
        bundle.putString("msg",intent1.getStringExtra("title"));
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }
}
