package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

import java.util.Timer;
import java.util.TimerTask;


public class FrameLayoutActivity extends Activity {

    private int currentColor=0;
    final int[] colors=new int[]{
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6
    };
    final int[] name=new int[]{
            R.id.FLTV1,
            R.id.FLTV2,
            R.id.FLTV3,
            R.id.FLTV4,
            R.id.FLTV5,
            R.id.FLTV6
    };
TextView[] views=new TextView[name.length];
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg)
        {
            if(msg.what==0x123)
            {
                for(int i=0;i<name.length;i++)
                {
                    views[i].setBackgroundResource(colors[(i+currentColor)%name.length]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        for(int i=0;i<name.length;i++)
        {
            views[i]=(TextView) findViewById(name[i]);
        }
        new Timer().schedule(new TimerTask(){
            public void run()
            {
                handler.sendEmptyMessage(0x123);
            }
        },0,200);
    }

}
