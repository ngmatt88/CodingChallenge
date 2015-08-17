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
import android.widget.ImageButton;

import com.goosewizards.codingchallenge.adapters.MyCoolAdapter;
import com.goosewizards.codingchallenge.fragments.MainFragment;
import com.goosewizards.codingchallenge.fragments.MovieListFragment;
import com.goosewizards.codingchallenge.fragments.SearchMovieFragment;
import com.goosewizards.codingchallenge.utilities.IApiMethods;
import com.goosewizards.codingchallenge.vos.RottenResponse;

import retrofit.RestAdapter;

public class MainActivity extends AppCompatActivity{

    public static Fragment mMainFragment = new MainFragment();
    ImageButton mHomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHomeBtn = (ImageButton) findViewById(R.id.goHomeBtn);
        mHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainFragment = new MainFragment();
                FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
                fragTransaction.replace(R.id.emptyFrameForFragment, mMainFragment);
                fragTransaction.commit();
            }
        });
    }


    @Override
    public void onStart(){
        super.onStart();
        FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.emptyFrameForFragment, mMainFragment);
        fragTransaction.commit();
    }
}
