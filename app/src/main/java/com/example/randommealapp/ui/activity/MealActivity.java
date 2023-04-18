package com.example.randommealapp.ui.activity;

import androidx.fragment.app.Fragment;

import com.example.randommealapp.ui.fragment.MealFragment;

public class MealActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return MealFragment.newInstance();
    }
}