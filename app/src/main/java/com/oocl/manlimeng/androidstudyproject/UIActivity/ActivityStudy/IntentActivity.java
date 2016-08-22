package com.oocl.manlimeng.androidstudyproject.UIActivity.ActivityStudy;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.oocl.manlimeng.androidstudyproject.R;

public class IntentActivity extends Activity {

    final static String STUDY_ACTION="com.oocl.manlimeng.androidstudyproject.STUDY_ACTION";
    final static String STUDY_CATIGORY="com.oocl.manlimeng.androidstudyproject.STUDY_CATIGORY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intent, menu);
        return true;
    }

    public void ComponentWay(View view)
    {
        ComponentName componentName=new ComponentName(IntentActivity.this,IntentResultActivity.class);
        Intent intent =new Intent();
        intent.setComponent(componentName);
        startActivity(intent);

    }
    public void ActionCategoryWay(View view)
    {
        Intent intent=new Intent();
        intent.setAction(IntentActivity.STUDY_ACTION);
        intent.addCategory(STUDY_CATIGORY);
        startActivity(intent);
    }
    public void GotoHome(View view)
    {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
        getResources().getIntArray(R.array.integerarray);

    }
    public void OverWrite(View view)
    {

        Intent intent=new Intent();
        intent.setType("abc/xyz");
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/test"));
        startActivity(intent);
    }
    public void OverWriteTypeAndData(View view)
    {
        Intent intent=new Intent();
        intent.setDataAndType(Uri.parse("lee://www.fkjava.org:8888/test"),"abc/xyz");
        startActivity(intent);
    }
    public void SetType(View view)
    {
        Intent intent=new Intent();
        intent.setType("abc/type");
        startActivity(intent);
    }
    public void SetData(View view)
    {
        Intent intent=new Intent();
        intent.setData(Uri.parse("lee://www.163.com:8888/test"));
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
