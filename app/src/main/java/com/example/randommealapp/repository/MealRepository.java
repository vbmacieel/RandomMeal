package com.example.randommealapp.repository;

import com.example.randommealapp.api.MealService;
import com.example.randommealapp.api.RetrofitConfig;
import com.example.randommealapp.model.Meal;
import com.example.randommealapp.model.MealResponse;

import retrofit2.Call;

public class MealRepository {
    private final MealService mMealService;

    public MealRepository(RetrofitConfig retrofit) {
        mMealService = retrofit.getMealService();
    }

    public Call<MealResponse> getRandomMeal() {
        return mMealService.getRandomMeal();
    }
}
