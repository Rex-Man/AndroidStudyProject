package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

public class BaseAdapterActivity extends Activity {

    ListView myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);
        myList= (ListView) findViewById(R.id.baseAdapter_listView);
        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return 40;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout line =new LinearLayout(BaseAdapterActivity.this);
                line.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView=new ImageView(BaseAdapterActivity.this);
                imageView.setImageResource(R.drawable.ic_launcher);
                TextView text=new TextView(BaseAdapterActivity.this);
                text.setText("the item"+(position+1));
                text.setTextSize(20);
                text.setTextColor(Color.RED);
                line.addView(imageView);
                line.addView(text);
                return line;
            }
        };
        myList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base_adapter, menu);
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
