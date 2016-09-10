package com.oocl.manlimeng.androidstudyproject.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

import org.w3c.dom.Text;

public class TransforServiceBroadcastActivity extends Activity {

    EditText editText;
    TextView textView;
    ServiceToActivityReceiver serviceToActivityReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfor_service_broadcast);
        editText= (EditText) findViewById(R.id.traseforBroadcast);
        textView=(TextView) findViewById(R.id.sendbackServiceValue);
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.oocl.manlimeng.action.SERVERTOACTIVITY");
        serviceToActivityReceiver=new ServiceToActivityReceiver();
        registerReceiver(serviceToActivityReceiver,intentFilter);

        Intent intent=new Intent(this,TransforService.class);
        startService(intent);
    }
    public void sendMessageToService(View view)
    {
        Intent intentSendToActivity=new Intent();
        intentSendToActivity.setAction("com.oocl.manlimeng.action.ACTIVITYTOSERVER");
        intentSendToActivity.putExtra("saveValue",Integer.valueOf(editText.getText().toString()));
        sendBroadcast(intentSendToActivity);
    }

    public class ServiceToActivityReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            String msg=intent.getStringExtra("backMsg");
            textView.setText(msg);
        }
    }

    @Override
    protected void onStop() {
        unregisterReceiver(serviceToActivityReceiver);
        super.onStop();
    }
}
