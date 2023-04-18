package com.example.randommealapp.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MealViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MealViewModel.class)) {
            return (T) new MealViewModel();
        } else {
            throw new IllegalArgumentException("ViewModel Not Found!");
        }
    }
}
