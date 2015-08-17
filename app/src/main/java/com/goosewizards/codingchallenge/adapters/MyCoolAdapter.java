package com.goosewizards.codingchallenge.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.goosewizards.codingchallenge.MovieDescriptionActivity;
import com.goosewizards.codingchallenge.R;
import com.goosewizards.codingchallenge.fragments.MovieDescripFragment;
import com.goosewizards.codingchallenge.vos.RottenResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Matt on 8/13/2015.
 */
public class MyCoolAdapter extends RecyclerView.Adapter<MyCoolAdapter.CustomViewHolder>{
    public static List<RottenResponse.Movies> movieItemList;
    private Context mContext;

    public MyCoolAdapter(Context context, List<RottenResponse.Movies> movieItemList){
        this.movieItemList = movieItemList;
        this.mContext = context;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        RottenResponse.Movies movieItem = movieItemList.get(i);

        //Download image using picasso library
        Picasso.with(mContext)
                .load(movieItem.posters.thumbnail)
                .into(customViewHolder.thumbnail);

        //Setting text view title
        customViewHolder.title.setText(movieItem.title);

        movieItemList.get(i).itemPosition = i;
    }

    @Override
    public int getItemCount() {
        return (null != movieItemList ? movieItemList.size() : 0);
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }





    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected ImageView thumbnail;
        protected TextView title;
        protected RelativeLayout container;

        public CustomViewHolder(View view) {
            super(view);
            this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            this.title= (TextView) view.findViewById(R.id.title);
            this.container = (RelativeLayout)view.findViewById(R.id.rowItem);

            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            Intent intent = new Intent(mContext, MovieDescriptionActivity.class);
            intent.putExtra("movie",getAdapterPosition());
            mContext.startActivity(intent);
        }
    }
}
