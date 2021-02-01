package com.reciclaje.ui.recicling;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReciclingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ReciclingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el modulo de reciclaje");
    }

    public LiveData<String> getText() {
        return mText;
    }
}