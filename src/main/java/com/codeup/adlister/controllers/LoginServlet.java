package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // TODO: find a record in your database that matches the submitted password
        // TODO: make sure we find a user with that username
        // TODO: check the submitted password against what you have in your database
        // TODO: store the logged in user object in the session, instead of just the username

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (password.isEmpty() || username.isEmpty()) {
            response.sendRedirect("/login");
        } else {
            try {
                User user = DaoFactory.getUsersDao().findByUsername(username);
                if (BCrypt.checkpw(password, user.getPassword())) {
                    request.getSession().setAttribute("user", user.getUsername());
                    request.getSession().setAttribute("email", user.getEmail());
                    response.sendRedirect("/profile");
                } else {
                    response.sendRedirect("/login");
                }
            } catch (Exception e) {
                response.sendRedirect("/register");
            }
        }
    }
}
