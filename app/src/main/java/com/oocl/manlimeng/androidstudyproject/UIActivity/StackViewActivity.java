package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import com.oocl.manlimeng.androidstudyproject.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackViewActivity extends Activity {

    int[] images=new int[]{
      R.drawable.bomb5,R.drawable.bomb6,R.drawable.bomb7,
            R.drawable.bomb8,R.drawable.bomb9,R.drawable.bomb10,
            R.drawable.bomb11, R.drawable.bomb12, R.drawable.bomb13,
            R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16
    };

    StackView stackView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);
        stackView= (StackView) findViewById(R.id.stackView_view1);
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for(int i=1;i<images.length;i++)
        {
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("images",images[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.cell,new String[]{"images"},new int[]{R.id.cell_imageView});
        stackView.setAdapter(simpleAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stack_view, menu);
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
    public void prevS(View source)
    {
        stackView.showPrevious();
    }
    public void nextS(View source)
    {
        stackView.showNext();
    }
}
