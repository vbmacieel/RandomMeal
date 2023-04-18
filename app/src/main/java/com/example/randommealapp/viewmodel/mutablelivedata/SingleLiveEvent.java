package com.example.randommealapp.viewmodel.mutablelivedata;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class SingleLiveEvent<T> extends MutableLiveData<T> {

    @MainThread
    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
        if (hasObservers()) {
            try {
                throw new Throwable("Only one observer at a time pls");
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        super.observe(owner, data -> {
            if (data == null) {
                return;
            }
            observer.onChanged(data);
            setValue(null);
        });
    }

    @MainThread
    public void sendAction(T data) {
        setValue(data);
    }
}
