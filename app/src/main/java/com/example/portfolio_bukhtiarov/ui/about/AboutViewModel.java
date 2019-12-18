package com.example.portfolio_bukhtiarov.ui.about;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Я студент кафедры Информатики и Прикладной Математики. Моя программа: 'Разработка программно-информационных систем.'");
    }

    public LiveData<String> getText() {
        return mText;
    }
}