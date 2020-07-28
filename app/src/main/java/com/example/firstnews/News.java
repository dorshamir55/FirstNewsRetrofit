package com.example.firstnews;

import com.google.gson.annotations.SerializedName;

public class News {
    @SerializedName("title")
    String title;
    @SerializedName("description")
    String description;
    @SerializedName("urlToImage")
    String image;
    @SerializedName("publishedAt")
    String date;
    @SerializedName("url")
    String webUrl;
    @SerializedName("author")
    String author;
    @SerializedName("content")
    String content;


    public News(String title, String description, String image, String date, String webUrl) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.date = date;
        this.webUrl = webUrl;
    }

    public News() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}

