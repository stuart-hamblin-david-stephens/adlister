package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {
    List<Category> all();
    Category findByID(int id);
    Category findByTitle(String title);
    int add(long ad_id, int cat_id);
    int delete(long id);
}
