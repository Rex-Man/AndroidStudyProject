package com.oocl.manlimeng.androidstudyproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by manre on 8/7/16.
 */
public class TestAsyncTask extends AsyncTask<Integer,Integer,String> {

    private TextView textView;
    private Context mContext;
    ProgressDialog progressDialog;

    public TestAsyncTask(TextView textView, Context mContext) {
        this.textView = textView;
        this.mContext = mContext;
    }

    @Override
    protected String doInBackground(Integer... params) {
        System.out.println("doInBackground");
        NetOperator netOperator=new NetOperator();
        int i=0;
        for(i=10;i<=params[0];i+=10){
            netOperator.operator();
            publishProgress(i);
        }
        return i+params[0].intValue()+"";
    }


    @Override
    protected void onPreExecute() {
        System.out.println("onPreExecute");
        progressDialog=new ProgressDialog(mContext);
        progressDialog.setTitle("任务正在执行中");
        progressDialog.setMessage("任务正在执行中，请稍后。。。。");
        progressDialog.setCancelable(false);
        progressDialog.setMax(1000);
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        System.out.println("onProgressUpdate");
        progressDialog.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        System.out.println("onPostExecute");
        textView.setText("异步执行操作结束"+ s);
        progressDialog.dismiss();
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
