package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.oocl.manlimeng.androidstudyproject.R;

import java.util.Calendar;

public class PickerActivity extends Activity {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        DatePicker datePicker= (DatePicker) findViewById(R.id.picker_dataPicker);
        TimePicker timePicker= (TimePicker) findViewById(R.id.picker_timerPicker);
        Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        hour=c.get(Calendar.HOUR_OF_DAY);
        minute=c.get(Calendar.MINUTE);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                PickerActivity.this.year = year;
                PickerActivity.this.month = monthOfYear;
                PickerActivity.this.day = dayOfMonth;
                showDate(year, monthOfYear, dayOfMonth, hour, minute);
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                PickerActivity.this.hour = hourOfDay;
                PickerActivity.this.minute = minute;
                showDate(year, month, day, hourOfDay, minute);
            }
        });
        NumberPicker lowerPricePicker= (NumberPicker) findViewById(R.id.picker_numberPicker01);
        NumberPicker hightPricePicker= (NumberPicker) findViewById(R.id.picker_numberPicker02);
        lowerPricePicker.setMinValue(10);
        lowerPricePicker.setMaxValue(50);
        lowerPricePicker.setValue(25);
        lowerPricePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Toast toast=Toast.makeText(PickerActivity.this,"your select Lower perice is"+newVal,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        hightPricePicker.setMinValue(10);
        hightPricePicker.setMaxValue(50);
        hightPricePicker.setValue(25);
        hightPricePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Toast toast=Toast.makeText(PickerActivity.this,"your select Highter perice is"+newVal,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void showDate(int year,int month,int day,int hour,int minute)
    {
        EditText show= (EditText) findViewById(R.id.picker_showET);
        show.setText("your buy date is "+year+"-"+month+"-"+day+"-"+hour+"-"+minute);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_picker, menu);
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
