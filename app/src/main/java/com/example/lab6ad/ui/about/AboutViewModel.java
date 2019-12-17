package com.example.lab6ad.ui.about;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is lab 6 for Android development course; Bukhtiarov Roman P3418");
    }

    public LiveData<String> getText() {
        return mText;
    }
}