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
    //    @GET("/public/v1.0/movies.json")
    @Headers("Content-Type: application/json")
    @GET("/movies.json")
    RottenResponse getMovies(
      @Query("apikey") String key,
      @Query("q") String title,
      @Query("page_limit") int page_limit,
      @Query("page") int page
    );

}
