package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.oocl.manlimeng.androidstudyproject.R;

import java.util.ArrayList;

public class ViewSwicherActivity extends Activity {

    ViewSwitcher viewSwitcher;
    public static final int NUMBER_PER_SCREEN=12;
    public static class DataItem
    {
        public String dataName;
        public Drawable drawable;
    }
    private ArrayList<DataItem> items =new ArrayList<DataItem>();
    private int screenCount;
    private int screenNo=-1;

    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_swicher);
        inflater=LayoutInflater.from(ViewSwicherActivity.this);
        for (int i=0;i<40;i++)
        {
            String label=""+i;
            Drawable drawable=getResources().getDrawable(R.drawable.ic_launcher);
            DataItem item=new DataItem();
            item.dataName=label;
            item.drawable=drawable;
            items.add(item);
        }
        screenCount=items.size()%NUMBER_PER_SCREEN==0?items.size()/NUMBER_PER_SCREEN:items.size()/NUMBER_PER_SCREEN+1;
        viewSwitcher= (ViewSwitcher) findViewById(R.id.viewSwicher_swicher1);
        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return inflater.inflate(R.layout.slidelistview,null);
            }
        });
        onViewSwicherNext(null);
    }
    private BaseAdapter adapter=new BaseAdapter() {
        @Override
        public int getCount() {
           if(screenNo==screenCount-1 && items.size()%NUMBER_PER_SCREEN!=0){
               return items.size()%NUMBER_PER_SCREEN;
           }
            return NUMBER_PER_SCREEN;
        }

        @Override
        public Object getItem(int position) {
            return items.get(screenNo * NUMBER_PER_SCREEN +position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view =convertView;
            if(convertView==null)
            {
                view=inflater.inflate(R.layout.labelicon,null);
            }
            ImageView imageView= (ImageView) view.findViewById(R.id.labelicon_imageview);
            imageView.setImageDrawable(((DataItem)getItem(position)).drawable);
            TextView textView=(TextView) view.findViewById(R.id.labelicon_textview);
            textView.setText(((DataItem)getItem(position)).dataName);
            return view;
        }
    };
    public void onViewSwicherPrev(View view){
        if (screenNo>0){
            screenNo--;
            viewSwitcher.setInAnimation(this,android.R.anim.slide_in_left);
            viewSwitcher.setOutAnimation(this,android.R.anim.slide_out_right);
            ((GridView) viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showPrevious();
        }
    }
    public void onViewSwicherNext(View view){

        if (screenNo<screenCount -1)
        {
            screenNo++;
            viewSwitcher.setInAnimation(this,R.anim.slide_in_right);
            viewSwitcher.setOutAnimation(this,R.anim.slide_out_left);
            ((GridView) viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showNext();
        }
    }

}
