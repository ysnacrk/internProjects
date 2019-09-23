package com.example.denemememe;

import android.graphics.Bitmap;
import android.media.Image;

public class Book {

    Bitmap bookImage;

    public Book(Bitmap bookImage) {
        this.bookImage = bookImage;
    }

    public Bitmap getBookImage() {
        return bookImage;
    }

    public void setBookImage(Bitmap bookImage) {
        this.bookImage = bookImage;
    }
}
