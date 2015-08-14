package com.goosewizards.codingchallenge.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.goosewizards.codingchallenge.R;

/**
 * Created by Matt on 8/13/2015.
 */
public class MovieDescripFragment extends Fragment {
    View mThisView;
    ImageView mPoster;
    TextView mTitle;
    TextView mDescription;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        mThisView = inflater.inflate(R.layout.fragment_descrip, container, false);
        mPoster = (ImageView)mThisView.findViewById(R.id.descripPoster);
        mTitle = (TextView)mThisView.findViewById(R.id.descripTitle);
        mDescription = (TextView)mThisView.findViewById(R.id.movieDescrip);

        return mThisView;
    }


    public View getmThisView() {
        return mThisView;
    }

    public ImageView getmPoster() {
        return mPoster;
    }

    public TextView getmTitle() {
        return mTitle;
    }

    public TextView getmDescription() {
        return mDescription;
    }
}
