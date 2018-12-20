package com.codeup.adlister.models;

public class Category {
    private int id;
    private String title;

    public Category() { }

    public Category(String title) {
        this.title = title;
    }

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
