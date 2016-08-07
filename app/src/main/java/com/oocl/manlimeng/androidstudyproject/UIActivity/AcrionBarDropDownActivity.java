package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.oocl.manlimeng.androidstudyproject.R;

public class AcrionBarDropDownActivity extends Activity implements ActionBar.OnNavigationListener , DummyFragment.OnFragmentInteractionListener {
    private static final String SELECTED_ITEM="select_item";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acrion_bar_drop_down);
        final ActionBar actionBar=getActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        actionBar.setListNavigationCallbacks(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,new String[]{"第一页","第二页","第三页"}),this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_acrion_bar_drop_down, menu);
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
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState.containsKey(SELECTED_ITEM))
        {
            getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(SELECTED_ITEM));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM,getActionBar().getSelectedNavigationIndex());
    }
    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        Fragment fragment=new DummyFragment();
        Bundle args=new Bundle();
        args.putInt(DummyFragment.ARG_SECTION_NUMBER, itemPosition + 1);
        fragment.setArguments(args);
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.acticon_bar_ralate, fragment);
        ft.commit();
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
