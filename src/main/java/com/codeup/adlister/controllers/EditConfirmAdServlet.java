package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ads/edit/confirm")
public class EditConfirmAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/profile");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long ad_id = (long) request.getSession().getAttribute("ad_id");
        String ad_title = request.getParameter("title");
        String ad_desc = request.getParameter("description");
        DaoFactory.getAdsDao().editAd(ad_id, ad_title, ad_desc);
        DaoFactory.getCatDao().delete(ad_id);
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
        response.sendRedirect("/profile");
    }
}
