package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.oocl.manlimeng.androidstudyproject.R;
import com.oocl.manlimeng.androidstudyproject.UIActivity.FragmentStudy.HandlerInMain2Activity;

public class HandlerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_handler, menu);
        return true;
    }
    public void HandlerInChildFunction(View view)
    {
        Intent intent=new Intent(HandlerActivity.this,HandlerInChildActivity.class);
        startActivity(intent);
    }
    public void HandlerInMainFunction(View view)
    {
        Intent intent=new Intent(HandlerActivity.this,HandlerInMainActivity.class);
        startActivity(intent);
    }
    public void HandlerInMainFunction2(View view)
    {
        Intent intent=new Intent(HandlerActivity.this,HandlerInMain2Activity.class);
        startActivity(intent);
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
