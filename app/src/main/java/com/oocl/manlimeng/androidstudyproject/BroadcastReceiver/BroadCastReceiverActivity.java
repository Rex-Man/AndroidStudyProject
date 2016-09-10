package com.oocl.manlimeng.androidstudyproject.BroadcastReceiver;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.oocl.manlimeng.androidstudyproject.R;

public class BroadCastReceiverActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_receiver);
    }


    public void nomalBroadcast(View view)
    {
        Intent intent=new Intent(BroadCastReceiverActivity.this,NormalBroadcastActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("title","Test Nomal BroadCast");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void orderedBroadcast(View view)
    {
        Intent intent=new Intent(BroadCastReceiverActivity.this,OrderBroadcastActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("title","Ordered BroadCast");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void visitserviceBroadcast(View view)
    {
        Intent intent=new Intent(BroadCastReceiverActivity.this,TransforServiceBroadcastActivity.class);
        startActivity(intent);
    }
}
