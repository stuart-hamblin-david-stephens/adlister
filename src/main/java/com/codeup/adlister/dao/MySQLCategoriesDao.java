package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
    private static Connection conn;

    public MySQLCategoriesDao(Config config) {
        if (conn == null) {
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                conn = DriverManager.getConnection(
                        config.getUrl(),
                        config.getUser(),
                        config.getPassword()
                );
            } catch (SQLException e) {
                throw new RuntimeException("Error connecting to the database!", e);
            }
        }
    }

    @Override
    public List<Category> all() {
        List<Category> categories = new ArrayList<>();
        PreparedStatement stmt;
        String sql = "SELECT * FROM categories";
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                categories.add(new Category(rs.getInt("id"), rs.getString("title")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findByID(int id) {
        Category result = new Category("oops");
        PreparedStatement stmt;
        String sql = "SELECT * FROM categories WHERE id = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                result = new Category(rs.getInt("id"), rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Category findByTitle(String title) {
        Category result = new Category("oops");
        PreparedStatement stmt;
        String sql = "SELECT * FROM categories WHERE title = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                result = new Category(rs.getInt("id"), rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(long id) {
        int result = 0;
        PreparedStatement stmt;
        String sql = "DELETE FROM ad_categories WHERE ad_id = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int add(long ad_id, int cat_id){
        int result = 0;
        PreparedStatement stmt;
        String sql = "INSERT INTO ad_categories (ad_id, cat_id) VALUES (?,?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, ad_id);
            stmt.setInt(2, cat_id);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
