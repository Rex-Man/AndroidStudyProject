package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oocl.manlimeng.androidstudyproject.R;

public class ArrayListViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list_view);

        ListView listView1= (ListView) findViewById(R.id.Adepter_list1);
        ListView listView2= (ListView) findViewById(R.id.Adepter_list2);

        String[] arr1={"arr1","arr2","arr3"};

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout.array_item,arr1);
        listView1.setAdapter(adapter1);
        String[] arr2={"JAVA","HIBERNATE","XML","SPRING"};
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,R.layout.checked_item,arr2);
        listView2.setAdapter(adapter2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_array_list_view, menu);
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
