package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private static Connection conn;

    public MySQLUsersDao(Config config) {
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
    public User findByUsername(String username) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users WHERE username = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                users.add(new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users.get(0);
    }

    @Override
    public Long insert(User user) {
        long bill = 0;
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            bill = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bill;
    }

    public static void main(String[] args) {
        System.out.println(new MySQLUsersDao(new Config()).findByUsername("BigBill").getUsername());
    }
}