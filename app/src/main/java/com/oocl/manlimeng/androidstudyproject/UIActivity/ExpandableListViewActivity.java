package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
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
import org.w3c.dom.Text;
import android.os.Bundle;
import android.app.Activity;

import com.oocl.manlimeng.androidstudyproject.R;


public class ExpandableListViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        ExpandableListAdapter expandableListAdapter=new ExpandableListAdapter() {
            int[] logos=new int[]{
                    R.drawable.p,
                    R.drawable.z,
                    R.drawable.t
            };

            private String[] armTypes=new String[]{
                    "神族兵种","虫族兵种","人族兵种"
            };

            private String[][] arms=new String[][]{
                    {"狂战士","龙骑士","黑暗圣堂","电兵"},{"小狗","刺蛇","飞龙","自曝飞机"},{"机枪冰","护士","幽灵"}
            };

            private TextView getTextView()
            {
                AbsListView.LayoutParams lp=new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64);
                TextView textView=new TextView(ExpandableListViewActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(10);
                return textView;
            }


            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

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
                LinearLayout ll= new LinearLayout(ExpandableListViewActivity.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ImageView logo=new ImageView(ExpandableListViewActivity.this);
                logo.setImageResource(logos[groupPosition]);
                ll.addView(logo);
                TextView tv=new TextView(ExpandableListViewActivity.this);
                tv.setText(getGroup(groupPosition).toString());
                ll.addView(tv);
                return ll;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView=getTextView();
                textView.setText(getChild(groupPosition,childPosition).toString());
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
        ExpandableListView expandableListView= (ExpandableListView) findViewById(R.id.expandableListView_ListView);
        expandableListView.setAdapter(expandableListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_expandable_list_view, menu);
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
