package com.yogi.services;

import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetrofitInstance {
    private static final  String URL="https://api.themoviedb.org/3/";
    public static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .addConverterFactory( GsonConverterFactory.create())
                .baseUrl(URL)
                .build();
    }
}

