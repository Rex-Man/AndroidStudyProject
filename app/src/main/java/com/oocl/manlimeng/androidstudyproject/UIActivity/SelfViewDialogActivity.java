package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import com.oocl.manlimeng.androidstudyproject.R;

public class SelfViewDialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_view_dialog);

        TableLayout loginForm= (TableLayout) getLayoutInflater().inflate(R.layout.activity_self_view_dialog,null);
        AlertDialog.Builder builder=new AlertDialog.Builder(this).setIcon(R.drawable.tools)
                .setTitle("自定义View对话框").setView(loginForm);
        builder.setPositiveButton("login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast=Toast.makeText(SelfViewDialogActivity.this,"login button click",Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast=Toast.makeText(SelfViewDialogActivity.this,"cancel button click",Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        }).create().show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_self_view_dialog, menu);
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
