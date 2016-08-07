package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;
import com.oocl.manlimeng.androidstudyproject.TestAsyncTask;

import org.w3c.dom.Text;

public class AsyncTaskActivity extends Activity {

    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        button= (Button) findViewById(R.id.async_button);
        button.setText("Start");
        textView= (TextView) findViewById(R.id.async_textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestAsyncTask testAsyncTask=new TestAsyncTask(textView,AsyncTaskActivity.this);
                testAsyncTask.execute(1000);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_async_task, menu);
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

