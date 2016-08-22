package com.oocl.manlimeng.androidstudyproject.UIActivity.FragmentStudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Handler;
import android.os.Message;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import com.oocl.manlimeng.androidstudyproject.R;

public class HandlerInMain2Activity extends Activity {
    private ProgressBar progress_bar = null;
    private Button start = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_in_main2);
        progress_bar = (ProgressBar)findViewById(R.id.progress_bar);
        start = (Button) findViewById(R.id.start);

        start.setOnClickListener(new StartOnClickListenr());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_handler_in_main2, menu);
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
    private class StartOnClickListenr implements OnClickListener
    {
        public void onClick(View v) {
            // TODO Auto-generated method stub
            //让进度条显示出来
            progress_bar.setVisibility(View.VISIBLE);
            //将线程加入到handler的线程队列中
            update_progress_bar.post(update_thread);

        }
    }
    //创建一个handler，内部完成处理消息方法
    Handler update_progress_bar = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            //super.handleMessage(msg);
            //显示进度条
            progress_bar.setProgress(msg.arg1);
            //重新把进程加入到进程队列中
            update_progress_bar.post(update_thread);
        }
    };//不加这个分号则不能自动添加代码

    Runnable update_thread = new Runnable()
    {
        int i = 0;
        public void run() {
            // TODO Auto-generated method stub
            i += 10;
            //首先获得一个消息结构
            Message msg = update_progress_bar.obtainMessage();
            //给消息结构的arg1参数赋值
            msg.arg1 = i;
            //延时1s，java中的try+catch用来排错处理
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            //把消息发送到消息队列中
            update_progress_bar.sendMessage(msg);
            if(i == 100)
                //把线程从线程队列中移除
                update_progress_bar.removeCallbacks(update_thread);
        }
    };
}
