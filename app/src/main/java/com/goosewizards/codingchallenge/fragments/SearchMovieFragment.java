package com.goosewizards.codingchallenge.fragments;

import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.goosewizards.codingchallenge.MainActivity;
import com.goosewizards.codingchallenge.R;
import com.goosewizards.codingchallenge.adapters.MyCoolAdapter;
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
        MainActivity.mMainFragment = fragment;
        FragmentManager fragManager
                = ((FragmentActivity) getActivity()).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        fragmentTransaction.replace(R.id.emptyFrameForFragment, fragment);
        fragmentTransaction.commit();

        InputMethodManager imm =
                (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

        APICallTask backgroundTask = new APICallTask(getActivity(),
                fragment,
                mSearchBar.getText().toString(), APICallTask.SearchTypes.SEARCH);

        backgroundTask.execute();
    }
}
