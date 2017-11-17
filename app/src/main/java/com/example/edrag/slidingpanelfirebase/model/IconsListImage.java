package com.example.edrag.slidingpanelfirebase.model;

/**
 * Created by edrag on 11/11/2017.
 */

public class IconsListImage {

    //    private String name;
    private Integer idIcon;
    private String title;

    public IconsListImage(String title, Integer idIcon) {
        this.idIcon = idIcon;
        this.title = title;
    }

    public Integer getIdIcon() {
        return idIcon;
    }

    public void setIdIcon(Integer idIcon) {
        this.idIcon = idIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    //
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

}
