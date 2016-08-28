package com.oocl.manlimeng.androidstudyproject.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
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
    private static final String TYPE_CATEGORY="vnd.android.cursor.dir/category";
    private static final String TYPE_ITEM_CATEGORY="vnd.android.cursor.item/category";

    public static final int BOOKS=1;
    public static final int BOOK=2;
    public static final int CATEGORY=3;
    public static final int CATEGORYS=4;

    MyDatabaseHelper dataHelper;
    static{
        matcher.addURI(AUTHORITY,"book",BOOKS);
        matcher.addURI(AUTHORITY,"book/#",BOOK);
        matcher.addURI(AUTHORITY,"category",CATEGORYS);
        matcher.addURI(AUTHORITY,"category/#",CATEGORY);
    }




    @Override
    public boolean onCreate() {

        dataHelper=new MyDatabaseHelper(this.getContext(),"BookStore.db",null, 2);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db=dataHelper.getReadableDatabase();
        Cursor cursor=null;
        switch(matcher.match(uri))
        {
            case BOOK:
                long id=ContentUris.parseId(uri);
                cursor=db.query("book", projection, "id=?", new String[]{String.valueOf(id)},null, null, sortOrder);
                break;
            case BOOKS:
                cursor=db.query("book", projection, selection, selectionArgs,null, null, sortOrder);
                break;
            case CATEGORY:
                long categoryId=ContentUris.parseId(uri);
                cursor=db.query("category", projection, "id=?", new String[]{String.valueOf(categoryId)},null, null, sortOrder);
                break;
            case CATEGORYS:
                cursor=db.query("category", projection, selection, selectionArgs,null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("未知Uri:"+uri);
        }
      return cursor;
    }

    @Override
    public String getType(Uri uri)
    {
        String returnValue="";
        switch (matcher.match(uri))
        {
            case BOOK:
                returnValue=TYPE_ITEM_DICT;
                break;
            case BOOKS:
                returnValue=TYPE_DICTS;
                break;
            case CATEGORY:
                returnValue=TYPE_CATEGORY;
                break;
            case CATEGORYS:
                returnValue=TYPE_ITEM_CATEGORY;
                break;
            default:
                throw new IllegalArgumentException("未知Uri:"+uri);
        }
        return returnValue;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db=dataHelper.getWritableDatabase();
        switch (matcher.match(uri))
        {
            case BOOKS:
                long id= db.insert("book",null,values);
                if(id>0)
                {
                    Uri newuri= ContentUris.withAppendedId(uri,id);
                    //getContext().getContentResolver().notifyChange(newuri,);
                    return newuri;
                }
                break;
            case CATEGORYS:
                long categoryId= db.insert("category",null,values);
                if(categoryId>0) {
                    Uri newuri = ContentUris.withAppendedId(uri, categoryId);
                    return newuri;
                }
            default:
                throw new IllegalArgumentException("未知Uri："+uri);
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db=dataHelper.getWritableDatabase();
        switch (matcher.match(uri)) {
            case BOOKS:
                return db.delete("book",selection,selectionArgs);
            case BOOK:
                long id=ContentUris.parseId(uri);
                return db.delete("book","id=?",new String[]{String.valueOf(id)});
            case CATEGORYS:
                return db.delete("category",selection,selectionArgs);
            case CATEGORY:
                long categoryId=ContentUris.parseId(uri);
                return db.delete("category","id=?",new String[]{String.valueOf(categoryId)});
            default:
                throw new IllegalArgumentException("未知Uri：" + uri);
        }
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db=dataHelper.getWritableDatabase();
        switch (matcher.match(uri)) {
            case BOOKS:
               return db.update("book",values,selection,selectionArgs);
            case BOOK:
                long bookId=ContentUris.parseId(uri);
               return db.update("book",values,"id=?",new String[]{String.valueOf(bookId)});
            case CATEGORYS:
                return db.update("category",values,selection,selectionArgs);
            case CATEGORY:
                long categoryId=ContentUris.parseId(uri);
                return db.update("category",values,"id=?",new String[]{String.valueOf(categoryId)});
            default:
                throw new IllegalArgumentException("未知Uri：" + uri);
        }
    }
}
