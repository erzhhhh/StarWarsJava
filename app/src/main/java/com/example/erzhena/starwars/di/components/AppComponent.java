package com.example.erzhena.starwars.di.components;

import android.content.Context;

import com.example.erzhena.starwars.activities.MainActivity;
import com.example.erzhena.starwars.api.StarWarsService;
import com.example.erzhena.starwars.di.modules.AppModule;
import com.example.erzhena.starwars.di.modules.StarWarsModule;
import com.example.erzhena.starwars.presenters.StarWarsFilmsPresenter;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {
        AppModule.class,
        StarWarsModule.class
})
public interface AppComponent {

    Retrofit exposerRetrofit();
    Context exposeContext();

    void injects(MainActivity mainActivity);

    void injects(StarWarsFilmsPresenter starWarsFilmsPresenter);

    void injects(StarWarsService starWarsService);
}
