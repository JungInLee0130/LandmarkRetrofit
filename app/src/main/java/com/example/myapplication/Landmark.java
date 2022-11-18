package com.example.myapplication;

public class Landmark {
    private String id;
    private String name;
    private String picture;

    public Landmark(String id, String name, String picture_path) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture_path(String picture_path) {
        this.picture = picture;
    }
}
