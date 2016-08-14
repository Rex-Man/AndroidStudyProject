package com.oocl.manlimeng.androidstudyproject.UIActivity.FragmentStudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.oocl.manlimeng.androidstudyproject.R;
import com.oocl.manlimeng.androidstudyproject.fragmentTranslateValue.activitytofragment.ActivityToFragmentActivity;

public class studyFragmentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_fragment);
    }

    public void StaticFragment(View view)
    {
        Intent intent=new Intent(studyFragmentActivity.this,StaticUseFragmentActivity.class);
        startActivity(intent);
    }
    public void ActiveFragment(View view)
    {
        Intent intent=new Intent(studyFragmentActivity.this,DynamicFragmentActivity.class);
        startActivity(intent);
    }
    public void FragmentConnect(View view)
    {
        Intent intent=new Intent(studyFragmentActivity.this,BookTwoPaneActivity.class);
        startActivity(intent);
    }

    public void ActivityTraslateValueToFragment(View view)
    {
        Intent intent=new Intent(studyFragmentActivity.this,ActivityToFragmentActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_study, menu);
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
