package com.example.marif.bloodapp.Entity;

/**
 * Created by Maryem on 2/13/2018.
 */

public class UserHistory {
    String date;
    String time;
    String bloodType;
    String bloodQuantity;
    public UserHistory(String d, String t,String bt,String bq) {
        date = d;
        time = t;
        bloodType = bt;
        bloodQuantity = bq;

    }
    public UserHistory()
    {

    }
    public String getdate() {
        return date;
    }

    public void setdate(String d) {
        date = d;
    }

    public String getbloodType() {
        return bloodType;
    }

    public void setbloodType(String bloodGroup) {
        bloodType = bloodGroup;
    }

    public String gettime() {
        return time;
    }

    public void settime(String d) {time = d;}

    public String getbloodQuantity() {
        return bloodQuantity;
    }

    public void setbloodQuantity(String bq) {
        bloodQuantity = bq;
    }
}
