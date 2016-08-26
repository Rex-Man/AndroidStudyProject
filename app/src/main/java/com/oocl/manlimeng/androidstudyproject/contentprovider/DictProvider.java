package com.oocl.manlimeng.androidstudyproject.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.oocl.manlimeng.androidstudyproject.Common.MyDatabaseHelper;

/**
 * Created by manre on 8/26/16.
 */
public class DictProvider extends ContentProvider {
    public static final String AUTHORITY="com.oocl.manlimeng.androidstudyproject.contentprovider.DictProvider";

    private static UriMatcher matcher=new UriMatcher(UriMatcher.NO_MATCH);
    private static final String TYPE_DICTS="vnd.android.cursor.dir/book";
    private static final String TYPE_ITEM_DICT="vnd.android.cursor.item/book";
    public static final int BOOKS=1;
    public static final int BOOK=2;
    public static final Uri DICT_URI=Uri.parse("content://"+AUTHORITY+"/book");
    MyDatabaseHelper dataHelper;
    static{
        matcher.addURI(AUTHORITY,"book",BOOKS);
        matcher.addURI(AUTHORITY,"book/#",BOOK);
    }




    @Override
    public boolean onCreate() {

        dataHelper=new MyDatabaseHelper(this.getContext(),"BookStore.db",null, 2);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db=dataHelper.getReadableDatabase();

        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db=dataHelper.getWritableDatabase();
        switch (matcher.match(uri))
        {
            case BOOKS:
                break;
            case BOOK:
                break;
            default:
                throw new IllegalArgumentException("未知Uri："+uri);
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db=dataHelper.getWritableDatabase();
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db=dataHelper.getWritableDatabase();
        return 0;
    }
}
