package com.example.randommealapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.randommealapp.viewmodel.mutablelivedata.SingleLiveEvent;
import com.example.randommealapp.api.RetrofitConfig;
import com.example.randommealapp.model.Meal;
import com.example.randommealapp.model.MealResponse;
import com.example.randommealapp.repository.MealRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealViewModel extends ViewModel {
    public SingleLiveEvent<Meal> mealSingleLiveEvent;
    public MutableLiveData<String> mErrorMessage;
    private final MealRepository mRepository;

    public MealViewModel() {
        RetrofitConfig retrofit = new RetrofitConfig();
        mRepository = new MealRepository(retrofit);
        mealSingleLiveEvent = new SingleLiveEvent<>();
    }

    public void getRandomMeal() {
        Call<MealResponse> call = mRepository.getRandomMeal();
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.body() != null) {
                    Meal[] meals = response.body().getMeals();
                    for (Meal meal : meals) {
                        mealSingleLiveEvent.sendAction(meal);
                    }
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                mErrorMessage.postValue(t.getMessage());
            }
        });
    }
}
