package com.example.edrag.slidingpanelfirebase.model;

/**
 * Created by edrag on 11/11/2017.
 */

public class IconsListImage {

    private String name;
    private String title;

    public IconsListImage(String name) {
        this.name = name;
    }

    public IconsListImage(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
