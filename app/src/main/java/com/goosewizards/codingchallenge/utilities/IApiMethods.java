package com.goosewizards.codingchallenge.utilities;

import com.goosewizards.codingchallenge.vos.RottenResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * Created by Matt on 8/13/2015.
 */
public interface IApiMethods {
    @Headers("Content-Type: application/json")
    @GET("/movies.json")
    RottenResponse getMovies(
      @Query("apikey") String key,
      @Query("q") String title,
      @Query("page_limit") int page_limit,
      @Query("page") int page
    );

    @Headers("Content-Type: application/json")
    @GET("/lists/movies/in_theaters.json")
    RottenResponse getInTheaters(
        @Query("apikey") String key
    );
}
