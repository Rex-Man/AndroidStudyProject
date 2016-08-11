package com.oocl.manlimeng.androidstudyproject.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manlimeng on 16/8/11.
 */
public class BookContent {
    public static List<Book> ITEMS =new ArrayList<Book>();
    public static Map<Integer,Book> ITEM_MAP=new HashMap<Integer,Book>();
    static
    {
        addItem(new Book(1,"疯狂Java讲义","一本全面,深入的Java学习图书,已被多家高校选做教材。"));
        addItem(new Book(2,"疯狂Android讲义","一本全面,深入的Android学习图书,已被多家高校选做教材。"));
        addItem(new Book(3,"疯狂XML讲义","一本全面,深入的XML学习图书,已被多家高校选做教材。"));
    }
    private static void addItem(Book book)
    {
        ITEMS.add(book);
        ITEM_MAP.put(book.getId(),book);
    }
}
