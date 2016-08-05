package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.oocl.manlimeng.androidstudyproject.R;

public class ActionBarItemActivity extends Activity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_item);
        textView= (TextView) findViewById(R.id.actionBar_item_textview);
        registerForContextMenu(textView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_action_bar_item, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_contextmenu, menu);
        menu.setHeaderIcon(R.drawable.tools);
        menu.setHeaderTitle("请选择背景色");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        item.setChecked(true);
        switch(item.getItemId())
        {
            case R.id.red:
                item.setChecked(true);
                textView.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                item.setChecked(true);
                textView.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                item.setChecked(true);
                textView.setBackgroundColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.isCheckable())
        {
            item.setChecked(true);
        }
        switch (item.getItemId())
        {
            case R.id.font_10:
                textView.setTextSize(10*2);
                break;
            case R.id.font_12:
                textView.setTextSize(12*2);
                break;
            case R.id.font_14:
                textView.setTextSize(14*2);
                break;
            case R.id.font_16:
                textView.setTextSize(16*2);
                break;
            case R.id.font_18:
                textView.setTextSize(18 * 2);
                break;
            case R.id.red_font:
                textView.setTextColor(Color.RED);
                item.setChecked(true);
                break;
            case R.id.blue_font:
                textView.setTextColor(Color.BLUE);
                item.setChecked(true);
                break;
            case R.id.green_font:
                textView.setTextColor(Color.GREEN);
                item.setChecked(true);
                break;
            case R.id.plain_item:
                Toast toast= Toast.makeText(this,"您单击了普通菜单项",Toast.LENGTH_SHORT);
                toast.show();
                break;
        }

        return true;

    }
}
