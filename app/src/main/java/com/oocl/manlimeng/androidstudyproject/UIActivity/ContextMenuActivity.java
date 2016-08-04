package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

public class ContextMenuActivity extends Activity {

    final int MENU1=0x111;
    final int MENU2=0x112;
    final int MENU3=0x113;

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        textView= (TextView) findViewById(R.id.contextmenu_textview);
        registerForContextMenu(textView);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu,View view,ContextMenu.ContextMenuInfo menuInfo)
    {
        menu.add(0,MENU1,0,"红色");
        menu.add(0,MENU2,0,"绿色");
        menu.add(0,MENU3,0,"蓝色");
        menu.setGroupCheckable(0,true,true);
        menu.setHeaderIcon(R.drawable.tools);
        menu.setHeaderTitle("选择背景色");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case MENU1:
                item.setChecked(true);
                textView.setBackgroundColor(Color.RED);
                break;
            case MENU2:
                item.setChecked(true);
                textView.setBackgroundColor(Color.GREEN);
                break;
            case MENU3:
                item.setChecked(true);
                textView.setBackgroundColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }

}
