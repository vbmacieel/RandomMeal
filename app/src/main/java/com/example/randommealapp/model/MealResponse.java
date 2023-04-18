package com.example.randommealapp.model;

import com.google.gson.annotations.SerializedName;

public class MealResponse {
    @SerializedName("meals")
    private Meal[] mMeals;

    public Meal[] getMeals() {
        return mMeals;
    }

    public void setMeals(Meal[] meals) {
        mMeals = meals;
    }
}
