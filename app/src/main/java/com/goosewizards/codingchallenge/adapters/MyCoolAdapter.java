package com.goosewizards.codingchallenge.adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.goosewizards.codingchallenge.R;
import com.goosewizards.codingchallenge.fragments.MovieDescripFragment;
import com.goosewizards.codingchallenge.vos.RottenResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Matt on 8/13/2015.
 */
public class MyCoolAdapter extends RecyclerView.Adapter<MyCoolAdapter.CustomViewHolder> implements View.OnClickListener{
    private List<RottenResponse.Movies> movieItemList;
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
    }

    @Override
    public int getItemCount() {
        return (null != movieItemList ? movieItemList.size() : 0);
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, null);
        view.setOnClickListener(this);
        CustomViewHolder viewHolder = new CustomViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onClick(View view){
        FragmentManager fragManager
                = ((FragmentActivity) view.getContext()).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        fragmentTransaction.replace(R.id.emptyFrameForFragment, new MovieDescripFragment());
        fragmentTransaction.commit();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView thumbnail;
        protected TextView title;

        public CustomViewHolder(View view) {
            super(view);
            this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            this.title= (TextView) view.findViewById(R.id.title);
        }
    }
}
