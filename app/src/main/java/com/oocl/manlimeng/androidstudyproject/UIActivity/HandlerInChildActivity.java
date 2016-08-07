package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

public class HandlerInChildActivity extends Activity {

    HandlerInChildThread handlerInChildThread;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_in_child);
        TextView textView= (TextView) findViewById(R.id.handlerInchild_textview);
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("任务正在执行中");
        progressDialog.setMessage("任务正在执行中，请稍后。。。。");
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(false);
        handlerInChildThread=new HandlerInChildThread(textView,progressDialog);
        handlerInChildThread.start();
        
        Button button= (Button) findViewById(R.id.handlerInchild_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                Message msg=new Message();
                msg.what=0x123;
                Bundle bundle=new Bundle();
                bundle.putInt(handlerInChildThread.UPPER_NUM,100);
                msg.setData(bundle);
                handlerInChildThread.mHandler.sendMessage(msg);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_handler_in_child, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
