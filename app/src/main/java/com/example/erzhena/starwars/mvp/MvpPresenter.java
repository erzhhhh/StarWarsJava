package com.example.erzhena.starwars.mvp;

import android.support.annotation.UiThread;

public interface MvpPresenter<V extends MvpView> {

    @UiThread
    void attachView(V view);

    @UiThread
    void detachView();
}