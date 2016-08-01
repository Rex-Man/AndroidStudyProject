package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.oocl.manlimeng.androidstudyproject.R;

public class AdapterViewFlipperActivity extends Activity {

    int[] imageIds=new int[]{
            R.drawable.shuangzi,R.drawable.shuangyu,R.drawable.chunv,
            R.drawable.tiancheng,R.drawable.tianxie,R.drawable.sheshou,
            R.drawable.juxie,R.drawable.shuiping,R.drawable.shizi,
            R.drawable.baiyang,R.drawable.jinniu,R.drawable.mojie
    };

    private AdapterViewFlipper adapterViewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper);
        adapterViewFlipper= (AdapterViewFlipper) findViewById(R.id.adapterViewFlipper_view1);
        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return imageIds[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                ImageView imageView=new ImageView(AdapterViewFlipperActivity.this);
                imageView.setImageResource(imageIds[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        adapterViewFlipper.setAdapter(adapter);
    }
    public void prev(View source)
    {
        adapterViewFlipper.showPrevious();
        adapterViewFlipper.stopFlipping();
    }
    public void next(View source)
    {
        adapterViewFlipper.showNext();
        adapterViewFlipper.stopFlipping();
    }
    public void auto(View source)
    {
        adapterViewFlipper.startFlipping();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adapter_view_flipper, menu);
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
