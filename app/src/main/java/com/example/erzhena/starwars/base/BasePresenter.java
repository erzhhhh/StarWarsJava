package com.example.erzhena.starwars.base;

import android.support.annotation.UiThread;

import com.example.erzhena.starwars.mvp.MvpPresenter;
import com.example.erzhena.starwars.mvp.MvpView;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private WeakReference viewRef;

    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<V>(view);

    }

    @UiThread
    public V getView() {
        if (viewRef == null) return null;
        else return (V) viewRef.get();
    }

    @UiThread
    public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    @Override
    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}



