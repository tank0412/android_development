package com.example.lab6ad.ui.playlist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlayListViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlayListViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}