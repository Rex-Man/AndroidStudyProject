package com.oocl.manlimeng.androidstudyproject.UIActivity.SaveStudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.oocl.manlimeng.androidstudyproject.R;

public class SaveStudyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_study);
    }
    public void saveStudyFilePreference(View view)
    {
        Intent intent = new Intent(SaveStudyActivity.this, SaveStudyFileActivity.class);
        startActivity(intent);
    }
    public void saveStudySharedPreference(View view)
    {
        Intent intent = new Intent(SaveStudyActivity.this, SaveStudySharedPreferenceActivity.class);
        startActivity(intent);
    }
    public void saveStudySDSave(View view)
    {
        Intent intent = new Intent(SaveStudyActivity.this, SaveStudySDActivity.class);
        startActivity(intent);
    }
    public void saveStudySQLiteSave(View view)
    {
        Intent intent = new Intent(SaveStudyActivity.this, SaveStudySQLITEActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_save_study, menu);
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
