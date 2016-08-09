package com.oocl.manlimeng.androidstudyproject.UIActivity.ActivityStudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;
import com.oocl.manlimeng.androidstudyproject.entity.Person;

import org.w3c.dom.Text;

public class ResultBundleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_bundle);
        TextView name= (TextView) findViewById(R.id.resultName);
        TextView password = (TextView) findViewById(R.id.resultPassword);
        TextView gender= (TextView) findViewById(R.id.resultGender);
        Intent intent=getIntent();
        Person person= (Person) intent.getSerializableExtra("person");
        name.setText(person.getName());
        password.setText(person.getPassword());
        gender.setText(person.getGender());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result_bundle, menu);
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
