package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import com.oocl.manlimeng.androidstudyproject.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageSwitcherActivity extends Activity {

    int[] imageIds=new int[]{
            R.drawable.bomb5,R.drawable.bomb6,R.drawable.bomb7,
            R.drawable.bomb8,R.drawable.bomb9,R.drawable.bomb10,
            R.drawable.bomb11,R.drawable.bomb12,R.drawable.bomb13,
            R.drawable.bomb14,R.drawable.bomb15,R.drawable.bomb16
    };

    ImageSwitcher imageSwitcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);
        imageSwitcher= (ImageSwitcher) findViewById(R.id.imageSwitch_switch_1);
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for (int i=0;i<imageIds.length;i++)
        {
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView=new ImageView(ImageSwitcherActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.cell,new String[]{"image"},new int[]{R.id.cell_imageView});
        GridView gridView= (GridView) findViewById(R.id.imangeSwitch_gridview);
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageSwitcher.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageSwitcher.setImageResource(imageIds[position]);
            }
        });
    }

}
