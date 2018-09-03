package com.example.erzhena.starwars;

import android.app.Application;

import com.example.erzhena.starwars.di.components.AppComponent;
import com.example.erzhena.starwars.di.components.DaggerAppComponent;
import com.example.erzhena.starwars.di.modules.AppModule;

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, "https://swapi.co/api/"))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}

