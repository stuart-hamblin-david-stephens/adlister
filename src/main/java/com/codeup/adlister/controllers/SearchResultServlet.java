package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/search/result")
public class SearchResultServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/search/result.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int search_by = Integer.parseInt(request.getParameter("search-by"));
        String query = request.getParameter("search-term");

        switch (search_by) {
            case 1:
                    request.setAttribute("ads_search", DaoFactory.getAdsDao().adsWithTitle(query));
                    request.getRequestDispatcher("/WEB-INF/search/result.jsp").forward(request, response);
                break;
            case 2:
                request.setAttribute("ads_search", DaoFactory.getAdsDao().adsByLikeUser(query));
                request.getRequestDispatcher("/WEB-INF/search/result.jsp").forward(request, response);
                break;
            case 3:
                request.setAttribute("ads_search", DaoFactory.getAdsDao().adsWithCategory(query));
                request.getRequestDispatcher("/WEB-INF/search/result.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("ads_search", DaoFactory.getAdsDao().masterSearch(query));
                request.getRequestDispatcher("/WEB-INF/search/result.jsp").forward(request, response);
                break;
        }

    }
}