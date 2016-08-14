package com.oocl.manlimeng.androidstudyproject.fragmentTranslateValue.fragmenttofragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.oocl.manlimeng.androidstudyproject.R;

public class FragmentToFragmentActivity extends Activity implements FragmentToFragmentFROM.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_fragment);

        FragmentToFragmentFROM fragmentFrom=new FragmentToFragmentFROM();
        getFragmentManager().beginTransaction().add(R.id.fragment_to_fragment_containerfrom, fragmentFrom).commit();

        FragmentToFragmentTo fragmentTo1=new FragmentToFragmentTo();
        Bundle bundle1=new Bundle();
        bundle1.putString("fragmentToFragment","fragmentTo01 default value 01");
        fragmentTo1.setArguments(bundle1);
        getFragmentManager().beginTransaction().add(R.id.fragment_to_fragment_containerto1, fragmentTo1).commit();

        FragmentToFragmentTo2 fragmentTo2=new FragmentToFragmentTo2();
        Bundle bundle2=new Bundle();
        bundle2.putString("fragmentToFragment","fragmentTo02 default value 02");
        fragmentTo2.setArguments(bundle2);
        getFragmentManager().beginTransaction().add(R.id.fragment_to_fragment_containerto2, fragmentTo2).commit();

        FragmentToFragmentTo3 fragmentTo3=new FragmentToFragmentTo3();
        Bundle bundle3=new Bundle();
        bundle3.putString("fragmentToFragment","fragmentTo03 default value 03");
        fragmentTo3.setArguments(bundle3);
        getFragmentManager().beginTransaction().add(R.id.fragment_to_fragment_containerto3, fragmentTo3).commit();
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
    public void sentEditMessageToOtherFragment(String value) {
        FragmentToFragmentTo fragmentTo1=new FragmentToFragmentTo();
        Bundle bundle=new Bundle();
        bundle.putString("fragmentToFragment",value);
        fragmentTo1.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.fragment_to_fragment_containerto1,fragmentTo1).commit();
    }
}
