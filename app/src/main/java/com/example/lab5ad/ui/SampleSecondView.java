package com.example.lab5ad.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SampleSecondView extends ViewModel {

    private MutableLiveData<String> mText;

    public SampleSecondView() {
        mText = new MutableLiveData<>();
        mText.setValue("This is second Sample fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}