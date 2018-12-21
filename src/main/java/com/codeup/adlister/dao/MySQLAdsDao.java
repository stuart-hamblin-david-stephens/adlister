package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.codeup.adlister.Config;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MySQLAdsDao implements Ads {
    private static Connection conn;

    public MySQLAdsDao(Config config) {
        if (conn == null) {
            try {
                DriverManager.registerDriver(new Driver());
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
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        PreparedStatement stmt;
        String sql = "SELECT * FROM ads";
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ads.add(new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        long bill = 0;
        String sql = "INSERT INTO ads (user_id, title, description) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                bill = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(bill);
        return bill;
    }

    @Override
    public List<Ad> adsByUser(String username) {
        List<Ad> userAds = new ArrayList<>();
        PreparedStatement stmt;
        String sql = "SELECT * FROM ads WHERE user_id = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, DaoFactory.getUsersDao().findByUsername(username).getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                userAds.add(new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userAds;
    }

    @Override
    public Ad findAdById(long id) {
        PreparedStatement stmt;
        String sql = "SELECT * FROM ads WHERE id = ?";
        Ad result = new Ad(1,1,"error", "You done goofed");
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                result = new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description"));
            } else {
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Long deleteAd(long id){
        Long result = 0L;
        PreparedStatement stmt;
        String sql = "DELETE FROM ads WHERE id = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            result = (long) stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Long editAd(long id, String title, String description){
        long result = 0;
        PreparedStatement stmt;
        String sql = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
        try {
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setLong(3, id);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Ad> adsWithTitle(String title) {
        List<Ad> userAds = new ArrayList<>();
        PreparedStatement stmt;
        String sql = "SELECT * FROM ads WHERE title LIKE ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                userAds.add(new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userAds;
    }

    public List<Ad> adsByLikeUser(String username) {
        List<Ad> userAds = new ArrayList<>();
        PreparedStatement stmt;
        String sql = "SELECT * FROM ads WHERE user_id IN (SELECT id FROM users WHERE username LIKE ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + username + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                userAds.add(new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userAds;
    }

    public List<Ad> adsWithCategory(String category) {
        List<Ad> userAds = new ArrayList<>();
        PreparedStatement stmt;
        String sql = "SELECT * FROM ads WHERE id IN (SELECT ad_id FROM ad_categories WHERE cat_id IN (SELECT id FROM categories WHERE title LIKE ?))";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + category + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                userAds.add(new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userAds;
    }

    @Override
    public List<Ad> masterSearch(String query) {
        List<Ad> userAds = new ArrayList<>();
        PreparedStatement stmt;
        String sql = "SELECT * FROM ads WHERE title LIKE ? || user_id IN (SELECT id FROM users WHERE username LIKE ?) || id IN (SELECT ad_id FROM ad_categories WHERE cat_id IN (SELECT id FROM categories WHERE title LIKE ?))";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + query + "%");
            stmt.setString(2, "%" + query + "%");
            stmt.setString(3, "%" + query + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                userAds.add(new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userAds;
    }
}
