package com.goosewizards.codingchallenge.vos;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Matt on 8/13/2015.
 */
public class RottenResponse {
    public String total;
    public List<Movies> movies;

    public class Movies implements Serializable{
        private static final long serialVersionUID = 1L;

        public String title;
        public String year;
        public String mpaa_rating;
        public String synopsis;
        public Posters posters;

        public int itemPosition;
    }

    public class Posters{
        public String thumbnail;
        public String original;
    }
}
