package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            request.getSession().setAttribute("redirect", "/profile");
            response.sendRedirect("/login");
            return;
        }

        request.getSession().removeAttribute("redirect");
        String currentUser = (String) request.getSession().getAttribute("user");
        System.out.println(currentUser);
        request.setAttribute("userAds", DaoFactory.getAdsDao().adsByUser(currentUser));
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long jim = Long.parseLong(request.getParameter("ad_id"));
        request.getSession().setAttribute("ad", DaoFactory.getAdsDao().findAdById((jim)));
        response.sendRedirect("/ads/view");
    }
}
