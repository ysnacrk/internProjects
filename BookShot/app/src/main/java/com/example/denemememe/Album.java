package com.example.denemememe;

import android.graphics.Bitmap;

public class Album {

    String name;
    String date;
    Bitmap cover;

    public Bitmap getCover() {
        return cover;
    }

    public void setCover(Bitmap cover) {
        this.cover = cover;
    }

    public Album(String name, String date, Bitmap cover) {
        this.name = name;
        this.date = date;
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
