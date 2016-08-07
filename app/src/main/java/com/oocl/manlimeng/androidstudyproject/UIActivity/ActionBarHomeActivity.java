package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

import org.w3c.dom.Text;

public class ActionBarHomeActivity extends Activity {

    TextView textView;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_home);
        textView= (TextView) findViewById(R.id.actionBar_home_textView);
        actionBar=getActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_action_bar_home, menu);
        MenuInflater inflator=new MenuInflater(this);
        inflator.inflate(R.menu.menu_action_bar_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.isCheckable())
        {
            item.setChecked(true);

        }
        switch (item.getItemId())
        {
            case android.R.id.home:
                Intent intent = new Intent(this, ActionBarHomeFirstActivity.class);
                // 添加额外的Flag，将Activity栈中处于FirstActivity之上的Activity弹出
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // 启动intent对应的Activity
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
