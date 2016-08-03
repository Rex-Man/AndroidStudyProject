
package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.os.Bundle;

import com.oocl.manlimeng.androidstudyproject.R;

public class OtherActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//设置该Activity显示的页面
		setContentView(R.layout.other);
	}
}