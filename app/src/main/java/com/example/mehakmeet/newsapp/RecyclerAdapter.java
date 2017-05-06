package com.example.mehakmeet.newsapp;

/**
 * Created by MEHAKMEET on 26/2/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    Activity activity;

    private String[] titles = {"International",
            "National",
            "Sports",
            "Business",
            "Entertainment",
            "Weather",
            "Technology"};

    private String[] details = {"contains international news details..",
            "contains national news details..", "contains sports news details..",
            "contains business news details..","contains entertainment news details..", "contains weather news details..",
            "contains technology news details.."};

    private int[] images = { R.drawable.interimg,
            R.drawable.nationimg,
            R.drawable.sportsimg,
            R.drawable.stock_marketimg,
            R.drawable.entertainment,
            R.drawable.weatherimg,
            R.drawable.technolgyimg};



    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            itemTitle = (TextView) itemView.findViewById(R.id.item_title);
            itemDetail =
                    (TextView) itemView.findViewById(R.id.item_detail);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}