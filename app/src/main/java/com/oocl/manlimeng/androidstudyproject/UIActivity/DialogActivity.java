package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

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
}
