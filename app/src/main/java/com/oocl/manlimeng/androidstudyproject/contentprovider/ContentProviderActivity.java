package com.oocl.manlimeng.androidstudyproject.contentprovider;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.oocl.manlimeng.androidstudyproject.R;
import com.oocl.manlimeng.androidstudyproject.UIActivity.ActivityStudy.IntentActivity;

public class ContentProviderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
    }
    public void ContentProviderSimple(View view)
    {
        Intent intent=new Intent(ContentProviderActivity.this,ContentProviderSimpleActivity.class);
        startActivity(intent);
    }
    public void ContentProviderDB(View view)
    {
        Intent intent=new Intent(ContentProviderActivity.this,ContentProviderDBActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_content, menu);
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
