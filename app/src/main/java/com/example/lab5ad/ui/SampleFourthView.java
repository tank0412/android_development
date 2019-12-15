package com.example.lab5ad.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SampleFourthView extends ViewModel {

    private MutableLiveData<String> mText;

    public SampleFourthView() {
        mText = new MutableLiveData<>();
        mText.setValue("This is fourth Sample fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}