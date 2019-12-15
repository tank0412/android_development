package com.example.lab5ad.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SampleFirstView extends ViewModel {

    private MutableLiveData<String> mText;

    public SampleFirstView() {
        mText = new MutableLiveData<>();
        mText.setValue("This is first Sample fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}