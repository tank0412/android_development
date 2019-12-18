package com.example.portfolio_bukhtiarov.ui.study;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StudyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Учусь в федеральное государственное автономное образовательное учреждение высшего образования\n" +
                "«Национальный исследовательский университет ИТМО»\n" +
                "\n" +
                "\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}