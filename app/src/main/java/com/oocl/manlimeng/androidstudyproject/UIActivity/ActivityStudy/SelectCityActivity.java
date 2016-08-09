package com.oocl.manlimeng.androidstudyproject.UIActivity.ActivityStudy;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

public class SelectCityActivity extends ExpandableListActivity {

    private String[] provices=new String[]
            {
                    "广东","广西","湖南"
            };
    private  String[][] cities=new String[][]{
            {"广州","深圳","珠海","中山"},
            {"桂林","柳州","南宁","北海"},
            {"长沙","岳阳","衡阳","株洲"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExpandableListAdapter adapter=new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return provices.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return cities[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return provices[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return cities[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout ll= new LinearLayout(SelectCityActivity.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ImageView logo=new ImageView(SelectCityActivity.this);
                //logo.setImageResource(logos[groupPosition]);
                ll.addView(logo);
                TextView tv=new TextView(SelectCityActivity.this);
                tv.setText(getGroup(groupPosition).toString());
                ll.addView(tv);
                return ll;

            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView=new TextView(SelectCityActivity.this);
                textView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64));
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {

            }

            @Override
            public void onGroupCollapsed(int groupPosition) {

            }

            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return 0;
            }
        };
        setListAdapter(adapter);
       getExpandableListView().setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
           @Override
           public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                 Intent intent=getIntent();
                 intent.putExtra("city",cities[groupPosition][childPosition]);
                 SelectCityActivity.this.setResult(0, intent);
                 SelectCityActivity.this.finish();


               return false;
           }
       });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_city, menu);
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
