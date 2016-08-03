package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import com.oocl.manlimeng.androidstudyproject.R;

public class TabHostActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);
        TabHost tabHost= getTabHost();
        TabHost.TabSpec tab1=tabHost.newTabSpec("TAB1").setIndicator("已接电话").setContent(R.id.tabHost_tab01);
        tabHost.addTab(tab1);
        TabHost.TabSpec tab2=tabHost.newTabSpec("TAB2").setIndicator("呼出电话").setContent(R.id.tabHost_tab02);
        tabHost.addTab(tab2);
        TabHost.TabSpec tab3=tabHost.newTabSpec("TAB3").setIndicator("未接电话").setContent(R.id.tabHost_tab03);
        tabHost.addTab(tab3);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab_host, menu);
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
}
