package com.goosewizards.codingchallenge;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.goosewizards.codingchallenge.adapters.MyCoolAdapter;
import com.goosewizards.codingchallenge.fragments.MainFragment;
import com.goosewizards.codingchallenge.fragments.MovieListFragment;
import com.goosewizards.codingchallenge.utilities.IApiMethods;
import com.goosewizards.codingchallenge.vos.RottenResponse;

import retrofit.RestAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static Fragment mMainFragment = new MainFragment();
    public static MovieListFragment movieListFragment = new MovieListFragment();
    private MyCoolAdapter adapter;
    private RecyclerView mRecyclerView;
    EditText mSearchBar;
    String mSearchTxt;
    Button mSearchBtn;
    public static final String API_URL = "http://api.rottentomatoes.com/api/public/v1.0";
    public static final String API_KEY = "yy5at44a4hzqqbsgnm4u47ju";
    public static final int PAGE_LIMIT = 20;
    public static int mPageNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearchBar = (EditText)findViewById(R.id.movieSrcBar);

        mSearchBtn = (Button)findViewById(R.id.movieSrchBtn);
        mSearchBtn.setOnClickListener(this);
    }


    @Override
    public void onStart(){
        super.onStart();
        FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.emptyFrameForFragment, mMainFragment);
        fragTransaction.commit();
    }


    @Override
    public void onClick(View v) {
        mSearchTxt = mSearchBar.getText().toString();
//        mMainFragment = new MovieListFragment();
        FragmentManager fragManager
                = ((FragmentActivity) MainActivity.this).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        fragmentTransaction.replace(R.id.emptyFrameForFragment, movieListFragment);
        fragmentTransaction.commit();

//        mRecyclerView = (RecyclerView)findViewById(R.id.movieList);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        new BackgroundTask().execute();
    }

    private class BackgroundTask extends AsyncTask<Void,Void,RottenResponse> {
        RestAdapter restAdapter;


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
                response = methods.getMovies(API_KEY,mSearchTxt,PAGE_LIMIT,mPageNumber);
            }catch (Exception e){
                System.out.println("THE ERROR IS:" + e.toString());
            }

            return response;
        }

        @Override
        protected void onPostExecute(RottenResponse results){
            adapter = new MyCoolAdapter(MainActivity.this,results.movies);
            movieListFragment.getmRecyclerView().setAdapter(adapter);
        }
    }



}
