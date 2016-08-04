package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;

import com.oocl.manlimeng.androidstudyproject.R;

public class MenuFunctionActivity extends Activity {
    final int FONT_10=0X111;
    final int FONT_12=0X112;
    final int FONT_14=0X113;
    final int FONT_16=0X114;
    final int FONT_18=0X115;
    final int PLAIN_ITEM=0x11b;
    final int FONT_RED=0x116;
    final int FONT_BLUE=0x117;
    final int FONT_GREEN=0x118;

    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_function);
        edit= (EditText) findViewById(R.id.menu_editText);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_menu, menu);
        SubMenu fontMenu=menu.addSubMenu("字体大小");
        fontMenu.setIcon(R.drawable.font);
        fontMenu.setHeaderIcon(R.drawable.font);
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0, FONT_10, 0, "10 号字体");
        fontMenu.add(0, FONT_12, 0, "12 号字体");
        fontMenu.add(0, FONT_14, 0, "14 号字体");
        fontMenu.add(0,FONT_16,0,"16 号字体");
        fontMenu.add(0,FONT_18,0,"18 号字体");

        menu.add(0, PLAIN_ITEM, 0, "普通菜单项");

        SubMenu colorMenu=menu.addSubMenu("选择颜色");
        colorMenu.setHeaderTitle("选择文字颜色");
        colorMenu.setHeaderIcon(R.drawable.color);
        colorMenu.setIcon(R.drawable.color);
        colorMenu.add(0, FONT_RED, 0, "红色");
        colorMenu.add(0,FONT_GREEN,0,"绿色");
        colorMenu.add(0,FONT_BLUE,0,"蓝色");

        SubMenu checkMenu=menu.addSubMenu("可以勾选的菜单");
        checkMenu.setIcon(R.drawable.font);
        checkMenu.setHeaderIcon(R.drawable.font);
        checkMenu.setHeaderTitle("选择勾选的菜单");
        checkMenu.add(0,0x121,0,"Item1").setCheckable(true);
        checkMenu.add(0,0x122,1,"Item2").setCheckable(false);
        checkMenu.add(0,0x123,2,"Item3").setCheckable(true);

        SubMenu checkGroupMenu=menu.addSubMenu("可以勾选的组菜单");
        checkGroupMenu.setIcon(R.drawable.font);
        checkGroupMenu.setHeaderIcon(R.drawable.font);
        checkGroupMenu.setHeaderTitle("选择勾选的组菜单");
        checkGroupMenu.setGroupCheckable(0,true,true);
        checkGroupMenu.add(0,0x131,0,"Item11");
        checkGroupMenu.add(0,0x132,1,"Item21");
        checkGroupMenu.add(0,0x133,2,"Item31");
        checkGroupMenu.add(1,0x144,0,"Item12");
        checkGroupMenu.add(1,0x144,1,"Item22");
        checkGroupMenu.add(1,0x146,2,"Item32");

        SubMenu progMenu=menu.addSubMenu("启动程序");
        progMenu.setHeaderIcon(R.drawable.font);
        progMenu.setHeaderTitle("选择要启动的程序");
        MenuItem menuItem=progMenu.add("查看Swift");
        menuItem.setIntent(new Intent(this,OtherActivity.class));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId())
        {
            case FONT_10:
                edit.setTextSize(10*2);
                break;
            case FONT_12:
                edit.setTextSize(12*2);
                break;
            case FONT_14:
                edit.setTextSize(14*2);
                break;
            case FONT_16:
                edit.setTextSize(16*2);
                break;
            case FONT_18:
                edit.setTextSize(18 * 2);
                break;
            case FONT_RED:
                edit.setTextColor(Color.RED);
                break;
            case FONT_BLUE:
                edit.setTextColor(Color.BLUE);
                break;
            case FONT_GREEN:
                edit.setTextColor(Color.GREEN);
                break;
            case PLAIN_ITEM:
                Toast toast= Toast.makeText(this,"您单击了普通菜单项",Toast.LENGTH_SHORT);
                toast.show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
