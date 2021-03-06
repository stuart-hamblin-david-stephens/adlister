package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // get a list of all ads by a particular user
    List<Ad> adsByUser(String username);

    List<Ad> adsByLikeUser(String username);

    List<Ad> adsWithTitle(String username);

    List<Ad> adsWithCategory(String username);

    List<Ad> masterSearch(String query);

    Ad findAdById(long id);

    Long deleteAd(long id);

    Long editAd(long id, String title, String description);

}
