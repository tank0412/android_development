package com.example.portfolio_bukhtiarov.ui.vkr;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VKRViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VKRViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Тема моей ВКР 'Разработка приложения для ОС Android'");
    }

    public LiveData<String> getText() {
        return mText;
    }
}