package com.codeup.adlister.controllers;

import com.codeup.adlister.Config;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditProfileServlet", urlPatterns = "/edit-profile")
public class EditProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/edit-profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String currentPassword = request.getParameter("current-password");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("password-confirm");
//        TODO
//        if(!username.isEmpty()){
//
//        }
//        TODO
//        if(!email.isEmpty()){
//
//        }
        User user = DaoFactory.getUsersDao().findByUsername(username);
        if(!currentPassword.isEmpty()){
            if(BCrypt.checkpw(password, user.getPassword())){
                if(passwordConfirm.equals(password)){
                    user.setPassword(password);
                    response.sendRedirect("/edit-profile");
                } else {
                    response.sendRedirect("/edit-profile");
                }
            }
        }
    }
}
