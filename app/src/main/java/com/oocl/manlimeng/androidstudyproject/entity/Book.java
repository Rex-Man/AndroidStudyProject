package com.oocl.manlimeng.androidstudyproject.entity;

/**
 * Created by manlimeng on 16/8/11.
 */
public class Book {
    private Integer id;
    private String title;
    private String desc;

    public Book(Integer id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
