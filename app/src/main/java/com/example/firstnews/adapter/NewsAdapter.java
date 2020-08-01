package com.example.firstnews.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstnews.model.Articles;
import com.example.firstnews.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<Articles> articlesList;
    private MyNewsListener listener;


    public NewsAdapter() {

    }

    public void setData(List<Articles> data) {
        articlesList = data;
    }

    interface MyNewsListener {
        void onNewsClicked(int position, View view);
    }

    public void setListener(MyNewsListener listener) {
        this.listener=listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleTv;
        TextView descriptionTv;
        ImageView imageIv;
        TextView dateTv;
        ViewHolder(View itemView){
            super(itemView);
            titleTv = itemView.findViewById(R.id.news_title_tv);
            descriptionTv = itemView.findViewById(R.id.news_description_tv);
            imageIv = itemView.findViewById(R.id.news_image_iv);
            dateTv = itemView.findViewById(R.id.news_date_tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null) {
                        Log.d("tag", "holder.itemView clicked");
                        assert articlesList != null;
                        listener.onNewsClicked(getAdapterPosition(), v);
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        assert articlesList != null;
        Articles articles = articlesList.get(position);
        holder.titleTv.setText(articles.getTitle());
        Picasso.get().load(articles.getUrlToImage()).resize(400,275).into(holder.imageIv);
        holder.descriptionTv.setText(articles.getDescription());
        holder.dateTv.setText(articles.getPublishedAt());

    }

    @Override
    public int getItemCount() {
        if (articlesList == null){
            return 0;
        }
        return articlesList.size();
    }
}