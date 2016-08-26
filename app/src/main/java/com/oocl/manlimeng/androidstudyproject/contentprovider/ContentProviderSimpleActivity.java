package com.oocl.manlimeng.androidstudyproject.contentprovider;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.oocl.manlimeng.androidstudyproject.R;

public class ContentProviderSimpleActivity extends Activity {
    ContentResolver contentResolver;
    Uri uri=Uri.parse("content://com.oocl.manlimeng.androidstudyproject.contentprovider.FirstProvider");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider_simple);
        contentResolver=getContentResolver();
    }

    public void ContentProviderSimpleQuery(View view)
    {
        Cursor cursor=contentResolver.query(uri,null,"query_where",null,null);
        Toast.makeText(this,"远程ContentProvider返回的Cursor为"+cursor,Toast.LENGTH_SHORT).show();
    }
    public void ContentProviderSimpleAdd(View view)
    {
        ContentValues values =new ContentValues();
        values.put("name","asdf");
        Uri newUri=contentResolver.insert(uri,values);
        Toast.makeText(this,"远程ContentProvider返回的insert为"+newUri,Toast.LENGTH_SHORT).show();
    }

    public void ContentProviderSimpleUpdate(View view)
    {
        ContentValues values =new ContentValues();
        values.put("name", "asdf");
        int count=contentResolver.update(uri,values,"update_where",null);
        Toast.makeText(this,"远程ContentProvider返回的insert为"+count,Toast.LENGTH_SHORT).show();
    }
    public void ContentProviderSimpleDelete(View view)
    {

        int count=contentResolver.delete(uri,"delete_where",null);
        Toast.makeText(this,"远程ContentProvider返回的insert为"+count,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_content_provider_simple, menu);
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
