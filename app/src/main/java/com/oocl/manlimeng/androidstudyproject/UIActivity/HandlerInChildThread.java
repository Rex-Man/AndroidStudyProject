package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;


/**
 * Created by manre on 8/7/16.
 */
public class HandlerInChildThread extends Thread {

    public Handler mHandler;
    private TextView textView;
    ProgressDialog progressDialog;
    public HandlerInChildThread(TextView textView, ProgressDialog progressDialog) {
        this.textView = textView;
        this.progressDialog = progressDialog;
    }

    static final String UPPER_NUM="upper";

    public void run()
    {
        Looper.prepare();
        mHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
              if(msg.what==0x123)
              {
                  int upper=msg.getData().getInt(UPPER_NUM);
                  NetOperator netOperator=new NetOperator();
                  int i=0;
                  for(i=10;i<=upper;i+=10){
                      if(i<upper) {
                          netOperator.operator();
                          progressDialog.setProgress(i);
                      }else{
                          progressDialog.dismiss();
                          //textView.setText(upper);
                      }
                  }
              }
            }
        };
        Looper.loop();
    }
    class NetOperator{
        public void operator()
        {
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }
}
