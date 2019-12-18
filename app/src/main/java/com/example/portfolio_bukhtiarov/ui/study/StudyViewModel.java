package com.example.portfolio_bukhtiarov.ui.study;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StudyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Учусь в федеральном государственном автономном образовательном учреждении высшего образования\n" +
                "«Национальном исследовательском университете ИТМО»\n" +
                "\n" +
                "\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}