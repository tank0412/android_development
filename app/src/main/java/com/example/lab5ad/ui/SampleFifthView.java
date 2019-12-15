package com.example.lab5ad.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SampleFifthView extends ViewModel {

    private MutableLiveData<String> mText;

    public SampleFifthView() {
        mText = new MutableLiveData<>();
        mText.setValue("This is fifth Sample fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}