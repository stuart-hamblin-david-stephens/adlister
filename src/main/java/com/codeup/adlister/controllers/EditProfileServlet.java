package com.codeup.adlister.controllers;

import com.codeup.adlister.EmailValidator;
import com.codeup.adlister.dao.DaoFactory;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/profile/edit")
public class EditProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            request.getSession().setAttribute("redirect", "/profile/edit");
            response.sendRedirect("/login");
            return;
        }
        request.getSession().removeAttribute("redirect");
        request.getRequestDispatcher("/WEB-INF/edit-profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmailValidator ev = new EmailValidator();

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String currentPassword = request.getParameter("current-password");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("password-confirm");

        boolean validPass = BCrypt.checkpw(currentPassword, DaoFactory.getUsersDao().findByUsername((String)request.getSession().getAttribute("user")).getPassword());

        if (username.isEmpty() || DaoFactory.getUsersDao().findByUsername(username).getUsername().equals(username) || !validPass) {
            username = (String) request.getSession().getAttribute("user");
        }

        if (email.isEmpty() || !ev.validateEmail(email) || DaoFactory.getUsersDao().findByEmail(email).getEmail().equals(email) || !validPass) {
            email = (String) request.getSession().getAttribute("email");
        }

        if (!validPass) {
            password = DaoFactory.getUsersDao().findByUsername((String) request.getSession().getAttribute("user")).getPassword();
        } else {
            if (!password.equals(passwordConfirm)) {
                password = DaoFactory.getUsersDao().findByUsername((String) request.getSession().getAttribute("user")).getPassword();
            } else {
                password = BCrypt.hashpw(password, BCrypt.gensalt());
            }
        }

        String oldUsername = (String) request.getSession().getAttribute("user");
        DaoFactory.getUsersDao().updateProfile(oldUsername, username, email, password);
        request.getSession().setAttribute("user", username);
        request.getSession().setAttribute("email", email);
        response.sendRedirect("/profile/edit");
    }
}
