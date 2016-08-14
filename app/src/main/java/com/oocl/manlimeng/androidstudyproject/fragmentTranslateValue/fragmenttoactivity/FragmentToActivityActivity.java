package com.oocl.manlimeng.androidstudyproject.fragmentTranslateValue.fragmenttoactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

public class FragmentToActivityActivity extends Activity implements FragmentToActivityFragment.OnFragmentInteractionListener {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to);
        textView= (TextView) findViewById(R.id.fragment_to_activity_show);
        FragmentToActivityFragment fragment=new FragmentToActivityFragment();

        getFragmentManager().beginTransaction().add(R.id.fragment_to_activity_container,fragment).commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragment_to, menu);
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

    @Override
    public String returnEditViewValue(String returnValue) {
        textView.setText(returnValue);
        return "testValue";
    }
}
