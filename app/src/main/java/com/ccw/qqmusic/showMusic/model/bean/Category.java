package com.ccw.qqmusic.showMusic.model.bean;

/**
 * Created by 蔡灿武 on 2016/10/19 0019.
 */

public class Category {
    private String category;
    private int id;

    public Category() {
    }

    public Category(String category, int id) {
        this.category = category;
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
