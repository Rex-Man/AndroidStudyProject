package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.oocl.manlimeng.androidstudyproject.R;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }
    public void menuFunction(View view)
    {
        Intent intent=new Intent(MenuActivity.this,MenuFunctionActivity.class);
        startActivity(intent);
    }
    public void contextMenu(View view)
    {
        Intent intent=new Intent(MenuActivity.this,ContextMenuActivity.class);
        startActivity(intent);
    }

}
