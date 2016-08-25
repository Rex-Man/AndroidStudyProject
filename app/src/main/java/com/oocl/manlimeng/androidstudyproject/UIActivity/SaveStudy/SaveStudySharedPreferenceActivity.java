package com.oocl.manlimeng.androidstudyproject.UIActivity.SaveStudy;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

public class SaveStudySharedPreferenceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_study_shared_preference);
        Button button= (Button) findViewById(R.id.SharedPreferenceButton);
        final TextView showValue= (TextView) findViewById(R.id.SharedPreferenceTV);

        SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        String name="xixi";
        String age="22";
        editor.putString("name", name);
        editor.putString("age", age);
        editor.commit();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
                String name=preferences.getString("name", "defaultname");
                String age=preferences.getString("age", "0");
                showValue.setText(name+"  "+age);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_save_study_shared_preference, menu);
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
