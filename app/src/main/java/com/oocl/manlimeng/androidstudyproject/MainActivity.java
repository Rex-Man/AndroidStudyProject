package com.oocl.manlimeng.androidstudyproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.oocl.manlimeng.androidstudyproject.UIActivity.ButtonActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.EditTextActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.FrameLayoutActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.GridLayoutActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ImageSwitcherActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.LinearLayoutActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.RelativeLayoutActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.SeekBarActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.SelfCreateActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.TableLayoutActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.TextSwitcherActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.TextViewActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ViewStudyActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ViewSwicherActivity;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView mylistview;
    private ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylistview = (ListView)findViewById(R.id.mainList);
        list.add("ViewStudy");
        list.add("SelfViewCreate");
        list.add("LinearLayout");
        list.add("AbsoluteLayout");
        list.add("TableLayout");
        list.add("RelativeLayout");
        list.add("FrameLayout");
        list.add("GridLayout");
        list.add("TextView");
        list.add("EditText");
        list.add("Button");
        list.add("SeekBar");
        list.add("ViewSwicher");
        list.add("ImageSwicher");
        list.add("TextSwicher");
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,list);
        mylistview.setAdapter(myArrayAdapter);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                if (list.get(arg2).equals("ViewStudy")) {
                    Intent intent = new Intent(MainActivity.this,ViewStudyActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("SelfViewCreate")) {
                    Intent intent = new Intent(MainActivity.this,SelfCreateActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("LinearLayout")) {
                    Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("AbsoluteLayout")) {
                    Intent intent = new Intent("com.wps.android.ABSOLUTELAYOUT");
                    startActivity(intent);
                }
                if (list.get(arg2).equals("TableLayout")) {
                    Intent intent = new Intent(MainActivity.this, TableLayoutActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("RelativeLayout")) {
                    Intent intent = new Intent(MainActivity.this ,RelativeLayoutActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("FrameLayout")) {
                    Intent intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("GridLayout")) {
                    Intent intent = new Intent(MainActivity.this, GridLayoutActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("TextView")) {
                    Intent intent = new Intent(MainActivity.this, TextViewActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("EditText")) {
                    Intent intent = new Intent(MainActivity.this, EditTextActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("Button")) {
                    Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("SeekBar")) {
                    Intent intent = new Intent(MainActivity.this, SeekBarActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("ViewSwicher")) {
                    Intent intent = new Intent(MainActivity.this, ViewSwicherActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("ImageSwicher")) {
                    Intent intent = new Intent(MainActivity.this, ImageSwitcherActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("TextSwicher")) {
                    Intent intent = new Intent(MainActivity.this, TextSwitcherActivity.class);
                    startActivity(intent);
                }
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
