package com.goosewizards.codingchallenge.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gc.materialdesign.views.ButtonRectangle;
import com.goosewizards.codingchallenge.MainActivity;
import com.goosewizards.codingchallenge.R;

import retrofit.RestAdapter;

/**
 * Created by Matt on 8/13/2015.
 */
public class MainFragment extends Fragment implements View.OnClickListener{
    private View mThisView;
    ButtonRectangle mSearchBtn;
    ButtonRectangle mInTheatersBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mThisView = inflater.inflate(R.layout.fragment_main, container, false);

        mInTheatersBtn = (ButtonRectangle)mThisView.findViewById(R.id.mainInTheatersBtn);
        mSearchBtn = (ButtonRectangle)mThisView.findViewById(R.id.mainSrchMovieBtn);

        mInTheatersBtn.setOnClickListener(this);
        mSearchBtn.setOnClickListener(this);

        return mThisView;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragManager = null;
        Fragment fragment = null;
        FragmentTransaction fragmentTransaction = null;
        switch(v.getId()){
            case R.id.mainInTheatersBtn:
                fragment = new InTheatersFragment();
                break;
            case R.id.mainSrchMovieBtn:
                fragment = new SearchMovieFragment();
                break;
        }

        if(fragment!=null){
            MainActivity.mMainFragment = fragment;
            fragManager = ((FragmentActivity) getActivity()).getSupportFragmentManager();
            fragmentTransaction = fragManager.beginTransaction();
            fragmentTransaction.replace(R.id.emptyFrameForFragment, fragment);
            fragmentTransaction.commit();
        }
    }
}
