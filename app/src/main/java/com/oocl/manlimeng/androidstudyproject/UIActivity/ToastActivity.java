package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.oocl.manlimeng.androidstudyproject.R;

public class ToastActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        CalendarView calendarView= (CalendarView) findViewById(R.id.toast_calendarView01);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast toast = Toast.makeText(ToastActivity.this, "your birthday is " + year + "-" + month + "-" + dayOfMonth, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
    
    public void onToastShowSimpleMessage(View view)
    {
        Toast toast= Toast.makeText(ToastActivity.this,"sample alert message",Toast.LENGTH_SHORT);
        toast.show();

    }
    public void onToastShowPictureMessage(View view)
    {
        Toast toast=new Toast(ToastActivity.this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        ImageView imageView=new ImageView(ToastActivity.this);
        imageView.setImageResource(R.drawable.ic_launcher);
        LinearLayout ll=new LinearLayout(ToastActivity.this);
        ll.addView(imageView);
        TextView textView=new TextView(ToastActivity.this);
        textView.setText("multipul alert message");
        textView.setTextSize(15);
        ll.addView(textView);
        toast.setView(ll);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toast, menu);
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
