package com.example.firstnews;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MainPOJO {

    @SerializedName("status")
    String status;
    @SerializedName("totalResults")
    String totalResults;
    @SerializedName("Articles")
    List<Articles> Articles = null;


    public class Articles {
        @SerializedName("source")
        Source source;
        @SerializedName("author")
        String author;
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
        @SerializedName("content")
        String content;

        public class Source {
            @SerializedName("id")
            String id;
            @SerializedName("name")
            String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public Source getSource() {
            return source;
        }

        public void setSource(Source source) {
            this.source = source;
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

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

    }

}
