package com.example.erzhena.starwars.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.erzhena.starwars.App;
import com.example.erzhena.starwars.R;
import com.example.erzhena.starwars.adapters.StarWarsFilmsAdapter;
import com.example.erzhena.starwars.contracts.StarWarFilmsContract;
import com.example.erzhena.starwars.models.FilmsResults;
import com.example.erzhena.starwars.presenters.StarWarsFilmsPresenter;

import java.util.List;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements StarWarFilmsContract.View {

    RecyclerView recyclerView;

    @Inject
    StarWarFilmsContract.Presenter starWarsFilmsPresenter;
    StarWarsFilmsAdapter starWarsFilmsAdapter;


    public void onCreate(Bundle savedInstance) {
        App.getAppComponent().injects(this);
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        starWarsFilmsPresenter.attachView(this);

        starWarsFilmsPresenter.loadFilms();

    }

    @Override
    public void showContent(List<FilmsResults> filmsResults) {
        starWarsFilmsAdapter = new StarWarsFilmsAdapter(this, filmsResults);
        recyclerView.setAdapter(starWarsFilmsAdapter);
    }

    @Override
    public void showError() {

    }
}
