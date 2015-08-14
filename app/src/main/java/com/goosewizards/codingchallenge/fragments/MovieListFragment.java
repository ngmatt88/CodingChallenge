package com.goosewizards.codingchallenge.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.goosewizards.codingchallenge.R;

import retrofit.RestAdapter;

/**
 * Created by Matt on 8/13/2015.
 */
public class MovieListFragment extends Fragment{
    private View mThisView;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        mThisView = inflater.inflate(R.layout.fragment_movie_list, container, false);
        mRecyclerView = (RecyclerView)mThisView.findViewById(R.id.movieList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return mThisView;
    }

    public RecyclerView getmRecyclerView(){
        return mRecyclerView;
    }
}
