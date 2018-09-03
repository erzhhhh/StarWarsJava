package com.example.erzhena.starwars.presenters;

import com.example.erzhena.starwars.App;
import com.example.erzhena.starwars.api.StarWarsService;
import com.example.erzhena.starwars.base.BasePresenter;
import com.example.erzhena.starwars.contracts.StarWarFilmsContract;
import com.example.erzhena.starwars.models.Films;
import com.example.erzhena.starwars.models.FilmsResults;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

public class StarWarsFilmsPresenter
        extends BasePresenter<StarWarFilmsContract.View>
        implements StarWarFilmsContract.Presenter {

    @Inject
    StarWarsService starWarsService;

    @Override
    public void loadFilms() {
        App.getAppComponent().injects(this);
        starWarsService.getFilms()
                .map(Films::getResults)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(filmsResults -> {
                    if (filmsResults != null) {
                        List<FilmsResults> targetList = Arrays.asList(filmsResults);
                        getView().showContent(targetList);
                    } else {
                        getView().showError();
                    }
                });
    }

    public StarWarsFilmsPresenter(@NotNull StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }
}
