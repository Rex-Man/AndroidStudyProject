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


import com.oocl.manlimeng.androidstudyproject.UIActivity.AdapterViewFlipperActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ArrayListViewActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.AutoCompleteTextActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.BaseAdapterActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ButtonActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.EditTextActivity;

import com.oocl.manlimeng.androidstudyproject.UIActivity.ExpandableListViewActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ExtendsListActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.FrameLayoutActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.GridLayoutActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.GridViewActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ImageButtonActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ImageViewActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ImageSwitcherActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.LinearLayoutActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.PickerActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ProgressBarActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.RelativeLayoutActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ScrollViewActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.SearchViewActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.SeekBarActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.SelfCreateActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.SimpleAdepterActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.SpinnerActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.StackViewActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.TabHostActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.TableLayoutActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.TextSwitcherActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.TextViewActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ToastActivity;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ViewFlipperActivity;
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
        list.add("ImageView");
        list.add("ImageButton");
        list.add("ArrayListView");
        list.add("ExtendsListActivity");
        list.add("SimpleAdapterActivity");
        list.add("BaseAdapterActivity");
        list.add("AutoCompleteTVActivity");
        list.add("GridViewActivity");
        list.add("ExpandableListActivity");
        list.add("SpinnerActivity");
        list.add("AdapterViewFlipperActivity");
        list.add("StackViewActivity");
        list.add("SeekBarActivity");
        list.add("ViewSwicherActivity");
        list.add("ImageSwicherActivity");
        list.add("TextSwitcherActivity");
        list.add("ProgressBarActivity");
        list.add("ToastActivity");
        list.add("PickerActivity");
        list.add("SearchViewActivity");
        list.add("ScrollViewActivity");
        list.add("ViewFlipperActivity");
        list.add("TabHostActivity");
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
                if (list.get(arg2).equals("ImageView")) {
                    Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);

                    startActivity(intent);
                }
                if (list.get(arg2).equals("ImageButton")) {
                    Intent intent = new Intent(MainActivity.this, ImageButtonActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("ArrayListView")) {
                    Intent intent = new Intent(MainActivity.this, ArrayListViewActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("ExtendsListActivity")) {
                    Intent intent = new Intent(MainActivity.this, ExtendsListActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("SimpleAdapterActivity")) {
                    Intent intent = new Intent(MainActivity.this, SimpleAdepterActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("BaseAdapterActivity")) {
                    Intent intent = new Intent(MainActivity.this, BaseAdapterActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("AutoCompleteTVActivity")) {
                    Intent intent = new Intent(MainActivity.this, AutoCompleteTextActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("GridViewActivity")) {
                    Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("ExpandableListActivity")) {
                    Intent intent = new Intent(MainActivity.this, ExpandableListViewActivity.class);
                    startActivity(intent);
                }

                if (list.get(arg2).equals("SpinnerActivity")) {
                    Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("AdapterViewFlipperActivity")) {
                    Intent intent = new Intent(MainActivity.this, AdapterViewFlipperActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("StackViewActivity")) {
                    Intent intent = new Intent(MainActivity.this, StackViewActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("TextSwitcherActivity")) {
                    Intent intent = new Intent(MainActivity.this, TextSwitcherActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("ProgressBarActivity")) {
                    Intent intent = new Intent(MainActivity.this, ProgressBarActivity.class);
                    startActivity(intent);
                }

                if (list.get(arg2).equals("SeekBarActivity")) {
                    Intent intent = new Intent(MainActivity.this, SeekBarActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("ViewSwicherActivity")) {
                    Intent intent = new Intent(MainActivity.this, ViewSwicherActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("ImageSwicherActivity")) {
                    Intent intent = new Intent(MainActivity.this, ImageSwitcherActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("ToastActivity")) {
                    Intent intent = new Intent(MainActivity.this, ToastActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("PickerActivity")) {
                    Intent intent = new Intent(MainActivity.this, PickerActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("SearchViewActivity")) {
                    Intent intent = new Intent(MainActivity.this, SearchViewActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("ScrollViewActivity")) {
                    Intent intent = new Intent(MainActivity.this, ScrollViewActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("ViewFlipperActivity")) {
                    Intent intent = new Intent(MainActivity.this, ViewFlipperActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("TabHostActivity")) {
                    Intent intent = new Intent(MainActivity.this, TabHostActivity.class);
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
