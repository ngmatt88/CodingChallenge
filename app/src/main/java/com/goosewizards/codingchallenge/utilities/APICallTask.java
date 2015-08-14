package com.goosewizards.codingchallenge.utilities;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;

import com.goosewizards.codingchallenge.adapters.MyCoolAdapter;
import com.goosewizards.codingchallenge.fragments.InTheatersFragment;
import com.goosewizards.codingchallenge.fragments.MovieListFragment;
import com.goosewizards.codingchallenge.vos.RottenResponse;

import retrofit.RestAdapter;

/**
 * Created by Matt on 8/13/2015.
 */
public class APICallTask extends AsyncTask<Void,Void,RottenResponse>{
    RestAdapter restAdapter;
    private MyCoolAdapter adapter;
    public static final String API_URL = "http://api.rottentomatoes.com/api/public/v1.0";
    public static final String API_KEY = "yy5at44a4hzqqbsgnm4u47ju";
    public static final int PAGE_LIMIT = 20;
    public static int mPageNumber = 1;
    String mMovieTxt;
    Context mContext;
    Fragment mMovieListFragment;
    SearchTypes mSearchType;

    public enum SearchTypes{INTHEATERS,SEARCH};


    public APICallTask(Context context, Fragment fragment, String movieTitle,SearchTypes searchType){
        this.mContext = context;
        this.mMovieListFragment =
                searchType.equals(SearchTypes.SEARCH) ? (MovieListFragment)fragment:(InTheatersFragment)fragment;
        this.mMovieTxt = movieTitle;
        this.mSearchType = searchType;
    }
        @Override
        protected void onPreExecute(){
            restAdapter = new RestAdapter.Builder()
                    .setEndpoint(API_URL)
                    .build();
        }

        @Override
        protected RottenResponse doInBackground(Void... params){
            IApiMethods methods = restAdapter.create(IApiMethods.class);
            RottenResponse response = null;

            try{
                switch(mSearchType){
                    case INTHEATERS:
                         response = methods.getInTheaters(API_KEY);
                        break;
                    case SEARCH:
                        response = methods.getMovies(API_KEY,mMovieTxt,PAGE_LIMIT,mPageNumber);
                        break;
                }

            }catch (Exception e){
                System.out.println("THE ERROR IS:" + e.toString());
            }

            return response;
        }

        @Override
        protected void onPostExecute(RottenResponse results){
            adapter = new MyCoolAdapter(mContext,results.movies);
            if(mMovieListFragment.getClass().equals(MovieListFragment.class)){
                ((MovieListFragment)mMovieListFragment).getmRecyclerView().setAdapter(adapter);
            }else{
                ((InTheatersFragment)mMovieListFragment).getmRecyclerView().setAdapter(adapter);
            }

        }

}
