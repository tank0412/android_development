package com.example.portfolio_bukhtiarov.ui.contacts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ContactsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Email для связи: romabukhtiarov@gmail.com");
    }

    public LiveData<String> getText() {
        return mText;
    }
}