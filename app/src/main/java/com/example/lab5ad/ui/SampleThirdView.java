package com.example.lab5ad.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SampleThirdView extends ViewModel {

    private MutableLiveData<String> mText;

    public SampleThirdView() {
        mText = new MutableLiveData<>();
        mText.setValue("This is third Sample fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}