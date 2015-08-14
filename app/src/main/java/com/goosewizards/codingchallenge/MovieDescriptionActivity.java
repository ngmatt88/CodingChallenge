package com.goosewizards.codingchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.goosewizards.codingchallenge.adapters.MyCoolAdapter;
import com.goosewizards.codingchallenge.vos.RottenResponse;
import com.squareup.picasso.Picasso;

public class MovieDescriptionActivity extends AppCompatActivity {
    RottenResponse.Movies movie;
    View mThisView;
    ImageView mPoster;
    TextView mTitle;
    TextView mDescription;
    int moviePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_description);

        Intent intent = getIntent();
        moviePosition = intent.getIntExtra("movie",-1);

        movie = MyCoolAdapter.movieItemList.get(moviePosition);

        mPoster = (ImageView)findViewById(R.id.descripPoster);
        mTitle = (TextView)findViewById(R.id.descripTitle);
        mDescription = (TextView)findViewById(R.id.movieDescrip);
    }

    @Override
    public void onStart(){
        super.onStart();

        mTitle.setText(movie.title);
        mDescription.setText(movie.synopsis);

        //Download image using picasso library
        Picasso.with(getApplicationContext())
                .load(movie.posters.original)
                .into(mPoster);
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_description, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
