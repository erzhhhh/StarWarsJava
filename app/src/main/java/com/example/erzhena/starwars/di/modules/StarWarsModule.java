package com.example.erzhena.starwars.di.modules;

import com.example.erzhena.starwars.api.StarWarsService;
import com.example.erzhena.starwars.contracts.StarWarFilmsContract;
import com.example.erzhena.starwars.presenters.StarWarsFilmsPresenter;

import javax.inject.Singleton;

import dagger.Module;
import retrofit2.Retrofit;
import dagger.Provides;

@Module
public class StarWarsModule {

    @Provides
    @Singleton
    public StarWarsService ProvideStarWarsService(Retrofit retrofit) {
        return retrofit.create(StarWarsService.class);
    }

    @Provides
    public StarWarFilmsContract.Presenter ProvideStarWarsPresenter(StarWarsService starWarsService) {
        return new StarWarsFilmsPresenter(starWarsService);
    }
}