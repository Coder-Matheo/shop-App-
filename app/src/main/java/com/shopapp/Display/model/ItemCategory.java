package com.shopapp.Display.model;

import java.util.ArrayList;

public class ItemCategory {
    private int image;
    private String name_song;




    public ItemCategory(int image, String name_song) {
        this.image = image;
        this.name_song = name_song;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName_song() {
        return name_song;
    }

    public void setName_song(String name_song) {
        this.name_song = name_song;
    }
}
