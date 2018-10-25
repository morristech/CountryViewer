package com.example.arman.testproject.presentation.main;

import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;

public interface MainView extends MvpView {
    void showMessage(@StringRes int msgRes);
    void showMessage(String msg);
    void showSelectedCountry(String countryName);
}
