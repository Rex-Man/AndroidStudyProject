package com.oocl.manlimeng.androidstudyproject.entity;

import java.io.Serializable;

/**
 * Created by manre on 8/9/16.
 */
public class Person implements Serializable {
    private String name;
    private String password;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
