package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.oocl.manlimeng.androidstudyproject.R;

public class ButtonActivity extends Activity {

    RadioGroup rg;
    CheckBox cb;
    TextView show;
    ToggleButton tb;
    Switch swich_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        rg= (RadioGroup) findViewById(R.id.button_rg);
        show=(TextView)findViewById(R.id.show);
        cb= (CheckBox) findViewById(R.id.button_checkbox);
        tb=(ToggleButton)findViewById(R.id.button_toggle);
        swich_button=(Switch)findViewById(R.id.button_swich);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String tip=checkedId ==R.id.male?"you are man":"you are woman";
                show.setText(tip);
            }
        });
        cb.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    show.setText("have checked Red");
                }else{
                    show.setText("have unchecked Red");
                }
            }
        });
       final LinearLayout  linear= (LinearLayout) findViewById(R.id.button_LinearLayout);
       CompoundButton.OnCheckedChangeListener listener=new CompoundButton.OnCheckedChangeListener(){

           public void onCheckedChanged(CompoundButton arg0, boolean isChecked){
                if (isChecked) {
                    linear.setOrientation(LinearLayout.HORIZONTAL);
                }else{
                    linear.setOrientation(LinearLayout.VERTICAL);
                }
           }

       };
        tb.setOnCheckedChangeListener(listener);
        swich_button.setOnCheckedChangeListener(listener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_button, menu);
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
