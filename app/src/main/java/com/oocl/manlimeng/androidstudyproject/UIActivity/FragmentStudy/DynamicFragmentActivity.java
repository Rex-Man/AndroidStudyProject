package com.oocl.manlimeng.androidstudyproject.UIActivity.FragmentStudy;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.oocl.manlimeng.androidstudyproject.R;

public class DynamicFragmentActivity extends Activity implements View.OnClickListener,ContentFragment.OnFragmentInteractionListener, TitleFragment.OnFragmentInteractionListener ,FriendFragment.OnFragmentInteractionListener{

    private Button weixin;
    private Button friend;
    private Button contract;
    private Button setting;
    private ContentFragment mWeixin;
    private FriendFragment mFriend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dynamic_fragment);
        weixin= (Button) findViewById(R.id.weixin);
        friend= (Button) findViewById(R.id.friend);
        contract= (Button) findViewById(R.id.contract);
        setting= (Button) findViewById(R.id.setting);
        weixin.setOnClickListener(this);
        friend.setOnClickListener(this);
        setDefaultFragment();

    }

    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mWeixin = new ContentFragment();
        transaction.replace(R.id.dynamic_frag_content, mWeixin);
        transaction.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dynamic, menu);
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
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();

        switch (v.getId())
        {
            case R.id.weixin:
                if (mWeixin == null)
                {
                    mWeixin = new ContentFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.dynamic_frag_content, mWeixin);
                break;
            case R.id.friend:
                if (mFriend == null)
                {
                    mFriend = new FriendFragment();
                }
                transaction.replace(R.id.dynamic_frag_content, mFriend);
                break;
        }
        // transaction.addToBackStack();
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
