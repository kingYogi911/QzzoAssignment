package com.yogi.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MoviesResponseModel {
    @SerializedName("page")
    int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<MovieModel> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(ArrayList<MovieModel> moviesList) {
        this.moviesList = moviesList;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    @SerializedName("results")
    ArrayList<MovieModel> moviesList;

    @SerializedName("total_pages")
    int total_pages;

    @SerializedName("total_results")
    int total_results;

}
