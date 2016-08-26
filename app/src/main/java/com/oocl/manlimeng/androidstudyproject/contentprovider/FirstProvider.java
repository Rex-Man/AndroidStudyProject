package com.oocl.manlimeng.androidstudyproject.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by manre on 8/26/16.
 */
public class FirstProvider extends ContentProvider {
    @Override
    public boolean onCreate() {
        System.out.println("onCreate");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        System.out.println(uri+"query");
        return null;
    }

    @Override
    public String getType(Uri uri) {
        System.out.println(uri+"type");
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        System.out.println(uri+"insert");
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        System.out.println(uri + "delete");
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        System.out.println(uri+"update");
        return 0;
    }
}
