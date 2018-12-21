package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(Long id);
    List<User> all();
    Long insert(User user);
    Long updateProfile(String oldUsername, String newUsername, String newEmail, String newPassword);
}
