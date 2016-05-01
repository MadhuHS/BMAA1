package com.jspiders.studentrealmdemo;

import io.realm.RealmObject;

/**
 * Created by mhs on 5/1/2016.
 */
public class Student extends RealmObject {

    private String iD;

    private String name;
    private String phone;

    public String getiD() {
        return iD;
    }

    public void setiD(String ID) {
        this.iD = ID;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }




}
