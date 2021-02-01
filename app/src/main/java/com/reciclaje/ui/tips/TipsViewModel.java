package com.reciclaje.ui.tips;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TipsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TipsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el modulo de tips");
    }

    public LiveData<String> getText() {
        return mText;
    }
}