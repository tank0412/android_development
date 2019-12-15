package com.example.lab5ad.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotSampleView extends ViewModel {

    private MutableLiveData<String> mText;

    public NotSampleView() {
        mText = new MutableLiveData<>();
        mText.setValue("This is not Sample fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}