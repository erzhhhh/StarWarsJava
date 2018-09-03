package com.example.erzhena.starwars.contracts;


import com.example.erzhena.starwars.models.FilmsResults;
import com.example.erzhena.starwars.mvp.MvpPresenter;
import com.example.erzhena.starwars.mvp.MvpView;

import java.util.List;

public interface StarWarFilmsContract {

    interface View extends MvpView {

        void showContent(List<FilmsResults> filmsResults);

        void showError();
    }

    interface Presenter extends MvpPresenter<View>{

        void loadFilms();

    }
}
