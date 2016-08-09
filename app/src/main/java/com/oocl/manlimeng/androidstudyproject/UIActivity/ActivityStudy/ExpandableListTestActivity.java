package com.oocl.manlimeng.androidstudyproject.UIActivity.ActivityStudy;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

public class ExpandableListTestActivity extends ExpandableListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_expandable_list_test);
        ExpandableListAdapter adapter=new BaseExpandableListAdapter() {
            int[] logos=new int[]{
                    R.drawable.p,
                    R.drawable.z,
                    R.drawable.t
            };
            private String[] armTypes=new String[]{
                    "神族兵种","虫族兵种","人族兵种"
            };
            private String[][] arms=new String[][]{
                    {"狂战士","龙骑士","黑暗圣堂","电兵"},
                    {"小狗","刺蛇","飞龙","自曝飞机"},
                    {"机枪兵","护士","幽灵","伞兵"},
            };



            @Override
            public int getGroupCount() {
                return armTypes.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return arms[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return armTypes[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return arms[groupPosition][childPosition];
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
                LinearLayout linearLayout=new LinearLayout(ExpandableListTestActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView=new ImageView(ExpandableListTestActivity.this);
                imageView.setImageResource(logos[groupPosition]);
                linearLayout.addView(imageView);
                TextView textView=new TextView(ExpandableListTestActivity.this);
                textView.setText(armTypes[groupPosition].toString());
                textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64));
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                linearLayout.addView(textView);
                return linearLayout;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

                TextView textView=new TextView(ExpandableListTestActivity.this);
                textView.setText(arms[groupPosition][childPosition].toString());
                textView.setTextSize(15);
                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
            }
        };
        setListAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_expandable_list_test, menu);
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
