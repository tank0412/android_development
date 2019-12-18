package com.example.portfolio_bukhtiarov.ui.plans;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlansViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlansViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Я планирую пройти обучение в компании EPAM в течении 3 месяцев и получить аозможность пройти стажировку с последующим трудоустройством.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}