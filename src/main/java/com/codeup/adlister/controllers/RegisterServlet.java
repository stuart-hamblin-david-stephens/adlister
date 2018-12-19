package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.EmailValidator;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private EmailValidator ev = new EmailValidator();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("password-confirm");

        try {
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || !passwordConfirm.equals(password) || !ev.validateEmail(email) || DaoFactory.getUsersDao().findByUsername(username).getUsername().equals(username) || DaoFactory.getUsersDao().findByEmail(email).getEmail().equalsIgnoreCase(email)) {
                response.sendRedirect("/register");
            } else {
                User user = new User(username, email, password);
                DaoFactory.getUsersDao().insert(user);
                try {
                    if (DaoFactory.getUsersDao().findByUsername(user.getUsername()) != null) {
                        request.getSession().setAttribute("user", user.getUsername());
                        response.sendRedirect("/profile");
                    } else {
                        response.sendRedirect("/register");
                    }
                } catch (Exception e) {
                    response.sendRedirect("/register");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            response.sendRedirect("/register");
        }
    }
}
//blue
