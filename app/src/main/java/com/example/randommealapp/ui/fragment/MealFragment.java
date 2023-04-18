package com.example.randommealapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.example.randommealapp.databinding.FragmentMealBinding;
import com.example.randommealapp.model.Meal;
import com.example.randommealapp.model.MealResponse;
import com.example.randommealapp.viewmodel.MealViewModel;
import com.example.randommealapp.viewmodel.MealViewModelFactory;

public class MealFragment extends Fragment {
    private FragmentMealBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = FragmentMealBinding.inflate(inflater, container, false);
        MealViewModel viewModel = new MealViewModelFactory().create(MealViewModel.class);

        viewModel.mealSingleLiveEvent.observe(getViewLifecycleOwner(), new Observer<Meal>() {
            @Override
            public void onChanged(Meal meal) {
                setMealCardView(meal);
            }
        });

        mBinding.generateMealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.getRandomMeal();
            }
        });

        mBinding.mealLayout.setVisibility(View.INVISIBLE);
        return mBinding.getRoot();
    }

    private void setMealCardView(Meal meal) {
        mBinding.mealName.setText(meal.getStrMeal());
        mBinding.mealCategory.setText(meal.getCategory());
        mBinding.mealArea.setText(meal.getArea());
        Glide.with(mBinding.getRoot()).load(meal.getImageUrl()).into(mBinding.mealImage);
        mBinding.mealVideoUrl.setText(meal.getVideoUrl());
        mBinding.mealSiteUrl.setText(meal.getSiteUrl());
        mBinding.mealLayout.setVisibility(View.VISIBLE);
    }

    public static MealFragment newInstance() {
        return new MealFragment();
    }
}
