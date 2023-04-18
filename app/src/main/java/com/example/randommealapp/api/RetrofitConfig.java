package com.example.randommealapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private final Retrofit mRetrofit;

    public RetrofitConfig() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public MealService getMealService() {
        return mRetrofit.create(MealService.class);
    }
}
