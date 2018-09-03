package com.example.erzhena.starwars.api;

import com.example.erzhena.starwars.models.Films;
import com.example.erzhena.starwars.models.Planets;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface StarWarsService {
    @GET("films")
    Observable<Films> getFilms();

    @GET("planets")
    public Observable<Planets> getPlanets();
}
