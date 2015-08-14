package com.goosewizards.codingchallenge.vos;

import java.util.List;

/**
 * Created by Matt on 8/13/2015.
 */
public class RottenResponse {
    public String total;
    public List<Movies> movies;

    public class Movies{
        public String title;
        public String year;
        public String mpaa_rating;
        public String synopsis;
        public Posters posters;
    }

    public class Posters{
        public String thumbnail;
    }
}
