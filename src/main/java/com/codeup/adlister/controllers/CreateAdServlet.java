package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            request.getSession().setAttribute("redirect", "/ads/create");
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = (String) request.getSession().getAttribute("user");
        Ad ad = new Ad(
            DaoFactory.getUsersDao().findByUsername(user).getId(),
            request.getParameter("title"),
            request.getParameter("description")
        );
        Long ad_id = DaoFactory.getAdsDao().insert(ad);
        String[] cat_ids= request.getParameterValues("categories");
        if (cat_ids != null) {
            int[] cat_ints = new int[cat_ids.length];
            for (int i = 0; i < cat_ints.length; i++) {
                cat_ints[i] = Integer.parseInt(cat_ids[i]);
            }
            for (int cat : cat_ints) {
                DaoFactory.getCatDao().add(ad_id, cat);
            }
        }

        response.sendRedirect("/ads");
    }
}
