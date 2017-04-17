package com.example.moreapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by android on 4/16/2017.
 */

public class MoreAppAdapter extends RecyclerView.Adapter<MoreAppAdapter.CustomAdapter> {

    public ArrayList<Items> itemsArrayList;
    public CallBcack callBcack;
    public Context context;


    public MoreAppAdapter(Context context , ArrayList<Items> itemsArrayList , CallBcack callBcack){
        this.context = context;
        this.itemsArrayList = itemsArrayList;
        this.callBcack = callBcack;
    }

    @Override
    public CustomAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_more_app , null);
        CustomAdapter customAdapter = new CustomAdapter(view);
        return customAdapter;
    }

    @Override
    public void onBindViewHolder(final CustomAdapter holder, int position) {
        final Items items = itemsArrayList.get(position);
        Glide.with(context).load(items.getImageId()).into(holder.imageView);
        holder.title.setText(items.getName());
        holder.ratingBar.setRating(items.getId());
        holder.install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hollywood_movie_link = items.getLink();
                Intent intent2 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id="
                                + hollywood_movie_link));
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent2);
            }
        });
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBcack.show(holder.getAdapterPosition() , items);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsArrayList.size();
    }


    public interface CallBcack{
        void show(int position , Items items);
    }


    public class CustomAdapter extends RecyclerView.ViewHolder{
        ImageView imageView;
        RatingBar ratingBar;
        TextView title;
        View view;
        Button install;
        public CustomAdapter(View itemView) {
            super(itemView);
            this.view = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.movieThumbnail);
            ratingBar = (RatingBar) itemView.findViewById(R.id.movieAudienceScore);
            title = (TextView) itemView.findViewById(R.id.movieTitle);
            install = (Button) itemView.findViewById(R.id.button);
        }
    }
}
