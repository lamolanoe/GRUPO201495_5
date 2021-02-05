package com.reciclaje.ui.points;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PointsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PointsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el modulo de puntos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
