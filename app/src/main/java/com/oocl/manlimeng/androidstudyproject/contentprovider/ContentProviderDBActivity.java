package com.oocl.manlimeng.androidstudyproject.contentprovider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import com.oocl.manlimeng.androidstudyproject.R;

public class ContentProviderDBActivity extends Activity {
    ContentResolver contentResolver;
    public static final String AUTHORITY="com.oocl.manlimeng.androidstudyproject.contentprovider.DictProvider";
    public static final Uri BOOK_URI=Uri.parse("content://"+AUTHORITY+"/book");
    public static final Uri CATEGORY_URI=Uri.parse("content://"+AUTHORITY+"/category");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider_db);
        contentResolver=getContentResolver();
    }
    public void ContentProviderQuery(View view)
    {
        //book
        Cursor cursor=contentResolver.query(BOOK_URI,null,null,null,null);
        //book
        Uri uri= ContentUris.withAppendedId(BOOK_URI,2);
        Cursor cursorDic=contentResolver.query(uri,null,null,null,null);

        //category
        Cursor cursorCategory=contentResolver.query(CATEGORY_URI,null,null,null,null);
        //category
        Uri uriCategory= ContentUris.withAppendedId(CATEGORY_URI,1);
        Cursor cursorCategoryDic=contentResolver.query(CATEGORY_URI,null,null,null,null);

        Toast.makeText(this,"远程ContentProvider返回的Cursor为"+cursor,Toast.LENGTH_SHORT).show();
    }
    public void ContentProviderAdd(View view)
    {
        //book
        ContentValues values=new ContentValues();
        //开始组装第一条数据
        values.put("name", "the da vinci code");
        values.put("author", "jack");
        values.put("pages", 500);
        values.put("price", 18.98);
        Uri bookUri=contentResolver.insert(BOOK_URI,values);
        values.clear();

        //category
        values.put("category_name", "the da vinci code");
        values.put("category_code", "jack");
        Uri categoryUri=contentResolver.insert(CATEGORY_URI,values);

        Toast.makeText(this,"远程ContentProvider返回的insert为"+bookUri,Toast.LENGTH_SHORT).show();
    }

    public void ContentProviderUpdate(View view)
    {
        ContentValues values =new ContentValues();
        values.put("name", "cnahge ");
        values.put("author", "jack");
        values.put("pages", 500);
        values.put("price", 18.98);
        Uri uri= ContentUris.withAppendedId(BOOK_URI,2);
        int count=contentResolver.update(uri,values,"id=?",new String[]{"2"});

        values.clear();
        values.put("category_name", "category1");
        values.put("category_code", "categorycode1");
        Uri uriCategory= ContentUris.withAppendedId(CATEGORY_URI,2);
        int countCategory=contentResolver.update(uriCategory,values,"id=?",new String[]{"2"});

        Toast.makeText(this,"远程ContentProvider返回的insert为"+count,Toast.LENGTH_SHORT).show();
    }
    public void ContentProviderDelete(View view)
    {
        Uri uri= ContentUris.withAppendedId(BOOK_URI,2);
        int count=contentResolver.delete(uri,"id=?",new String[]{"2"});

        Uri uriCategory= ContentUris.withAppendedId(CATEGORY_URI,2);
        int countCategory=contentResolver.delete(uriCategory,"id=?",new String[]{"2"});
        Toast.makeText(this,"远程ContentProvider返回的insert为"+count,Toast.LENGTH_SHORT).show();
    }

}
