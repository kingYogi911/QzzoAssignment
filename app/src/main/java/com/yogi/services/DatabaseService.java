package com.yogi.services;

import com.yogi.models.MoviesResponseModel;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface DatabaseService {
    @GET("movie/popular?api_key=4e44d9029b1270a757cddc766a1bcb63")
    Call<MoviesResponseModel> getAllMovies();
}
