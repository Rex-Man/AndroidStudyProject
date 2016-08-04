package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.oocl.manlimeng.androidstudyproject.R;

import java.util.Calendar;



public class DialogActivity extends Activity {

    TextView textView;
    String[] items =new String[]{"Java","Xml","Ajax","Android"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        textView= (TextView) findViewById(R.id.dealog_show);
    }
    public void simple(View view)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this).setTitle("简单对话框").setIcon(R.drawable.ic_launcher)
                .setMessage("对话框的测试内容\n 第二行内容");
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();

    }

    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder)
    {
        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("Click queding");
            }
        });
    }
    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder)
    {
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("Click quxiao");
            }
        });
    }
    public void simpleList(View view)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("简单列表对话框")
                .setIcon(R.drawable.ic_launcher)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("Click "+items[which]);
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();

    }
    public void SingleChoice(View view)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.tools);
        builder.setTitle("单选列表项对话框");
        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("you have choose:" + items[which]);
            }
        });
        setNegativeButton(builder);
        setPositiveButton(builder).create().show();

    }
    public void MultiChoice(View view)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.tools);
        builder.setTitle("多选列表项对话框");
        builder.setMultiChoiceItems(items, new boolean[]{false, true, true, true}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                textView.setText("you have choose:" + items[which] + " click value: " + isChecked);
            }
        });
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();
    }
    public void CustomDialog(View view)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("自定义列表项对话框");
        builder.setIcon(R.drawable.tools);
        builder.setAdapter(new ArrayAdapter<String>(this, R.layout.array_item, items), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("you have choose:" + items[which]);
            }
        });
        setNegativeButton(builder);
        setPositiveButton(builder).create().show();


    }
    public void Popupwindow(View view)
    {
//        Intent intent=new Intent(DialogActivity.this,PopupWindowActivity.class);
//        startActivity(intent);

        View root=this.getLayoutInflater().inflate(R.layout.activity_popup_window,null);
        final PopupWindow popupwindow=new PopupWindow(root, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        popupwindow.showAtLocation(findViewById(R.id.dialog_popupwindow), Gravity.CENTER, 20, 20);
        root.findViewById(R.id.popup_CloseButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupwindow.dismiss();
            }
        });


    }
    public void SelfViewDialog(View view)
    {
        Intent intent=new Intent(DialogActivity.this,SelfViewDialogActivity.class);
        startActivity(intent);
    }
    public void ThemeViewDialog(View view)
    {
        Intent intent=new Intent(DialogActivity.this,ThemeViewDialogActivity.class);
        startActivity(intent);
    }
    public void DatePickerDialog(View view)
    {

        Calendar calendar= Calendar.getInstance();
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast toast=Toast.makeText(DialogActivity.this,"select Date:"+year+"-"+monthOfYear+"-"+dayOfMonth,Toast.LENGTH_SHORT);
                toast.show();
            }
        }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
    public void TimePickerDialog(View view)
    {
        Calendar calendar= Calendar.getInstance();
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast toast=Toast.makeText(DialogActivity.this,"select TIME:"+hourOfDay+"-"+minute,Toast.LENGTH_SHORT);
                toast.show();
            }
        }, calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),true);
        timePickerDialog.show();
    }
    final static int MAX_PROGRESS=100;
    private int[] data=new int[50];
    int progressStatus=0;
    int hasdata=0;
    ProgressDialog p1,p2;
    Handler handler =new Handler() {
        public void handleMessage(Message msg)
        {
            if(msg.what==0x123)
            {
                p2.setProgress(progressStatus);
            }
        }
    };

    public void ProgressDialog_Spinner(View view)
    {
        ProgressDialog.show(this,"任务执行中","任务执行中，请等待。。。",false,true);
    }
    public void ProgressDialog_Indeter(View view)
    {
      p1=new ProgressDialog(this);
        p1.setTitle("任务执行中");
        p1.setMessage("任务执行中，请等待。。。");
        p1.setCancelable(true);
        p1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        p1.setIndeterminate(true);
        p1.show();
    }
    public void ProgressDialog_Progress(View view)
    {
        progressStatus=0;
        hasdata=0;
        p2=new ProgressDialog(this);
        p2.setMax(MAX_PROGRESS);
        p2.setTitle("任务执行完成百分比");
        p2.setMessage("耗时任务的完成百分比");
        p2.setCancelable(false);
        p2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        p2.setIndeterminate(false);
        p2.show();
        new Thread()
        {
            public void run()
            {
                while(progressStatus<MAX_PROGRESS)
                {
                    progressStatus=MAX_PROGRESS*doWork()/data.length;
                    handler.sendEmptyMessage(0x123);
                }
                if(progressStatus>=MAX_PROGRESS)
                {
                    p2.dismiss();
                }
            }
        }.start();
    }
    public int doWork()
    {
        data[hasdata++]= (int) (Math.random()*100);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasdata;
    }
}
