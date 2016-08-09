package com.oocl.manlimeng.androidstudyproject.UIActivity.ActivityStudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.oocl.manlimeng.androidstudyproject.R;
import com.oocl.manlimeng.androidstudyproject.entity.Person;

public class BundleTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_test);
        Button button= (Button) findViewById(R.id.bundlesubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText name= (EditText) findViewById(R.id.bundleName);
                EditText password= (EditText) findViewById(R.id.bundlePassword);
                RadioButton radioButton= (RadioButton) findViewById(R.id.bundlemale);
                String gender=radioButton.isChecked()?"男":"女";
                Person person=new Person();
                person.setGender(gender);
                person.setName(name.getText().toString());
                person.setPassword(password.getText().toString());
                Bundle bundle=new Bundle();
                bundle.putSerializable("persion",person);
                Intent intent=new Intent(BundleTestActivity.this,ResultBundleActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bundle_test, menu);
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
