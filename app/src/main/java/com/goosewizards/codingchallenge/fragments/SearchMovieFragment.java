package com.goosewizards.codingchallenge.fragments;

import android.graphics.Movie;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.goosewizards.codingchallenge.R;
import com.goosewizards.codingchallenge.utilities.APICallTask;

/**
 * Created by Matt on 8/13/2015.
 */
public class SearchMovieFragment extends Fragment implements View.OnClickListener{
    View mThisView;
    Button mSearchBtn;
    EditText mSearchBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        mThisView = inflater.inflate(R.layout.fragment_search, container, false);

        mSearchBtn = (Button)mThisView.findViewById(R.id.movieSrchBtn);
        mSearchBar = (EditText)mThisView.findViewById(R.id.movieSrcBar);

        mSearchBtn.setOnClickListener(this);

        return mThisView;
    }

    @Override
    public void onClick(View v){
//        mSearchTxt = mSearchBar.getText().toString();
        MovieListFragment fragment = new MovieListFragment();
        FragmentManager fragManager
                = ((FragmentActivity) getActivity()).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        fragmentTransaction.replace(R.id.emptyFrameForFragment, fragment);
        fragmentTransaction.commit();

//        MovieListFragment movieListFrag =
//                (MovieListFragment)(getActivity().getSupportFragmentManager().findFragmentById(R.id.srchListFragment));

//        APICallTask.SearchTypes search = null;
//        switch (v.getId()){
//            case R.id.mainInTheatersBtn: search = APICallTask.SearchTypes.INTHEATERS;
//                break;
//            case R.id.mainSrchMovieBtn: search = APICallTask.SearchTypes.SEARCH;
//                break;
//        }

        APICallTask backgroundTask = new APICallTask(getActivity(),
                fragment,
                mSearchBar.getText().toString(), APICallTask.SearchTypes.SEARCH);

        backgroundTask.execute();
    }
}
