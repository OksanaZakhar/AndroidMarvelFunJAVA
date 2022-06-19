package com.ksusha.vel.marvelfanj.presentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ksusha.vel.marvelfanj.data.localdata.HeroMarvel;
import com.ksusha.vel.marvelfanj.data.localdata.repository.MarvelRepositoryLocalData;

import java.util.List;

public class FavoriteListActivityViewModel extends AndroidViewModel {

    MarvelRepositoryLocalData marvelRepositoryLocalData;
    private LiveData<List<HeroMarvel>> heroes;
    private LiveData<List<String>> heroesId;

    public FavoriteListActivityViewModel(@NonNull Application application) {
        super(application);

        marvelRepositoryLocalData = new MarvelRepositoryLocalData(application);
    }

    public LiveData<List<HeroMarvel>> getHeroes() {
        heroes = marvelRepositoryLocalData.getHeroMarvel();
        return heroes;
    }

    public LiveData<List<String>> getIdHeroes() {
        heroesId = marvelRepositoryLocalData.getAllIdHeroMarvel();
        return heroesId;
    }

    public void insertHeroMarvel(HeroMarvel heroMarvel) {
        marvelRepositoryLocalData.insertHeroesMarvel(heroMarvel);
    }

    public void updateHeroMarvel(HeroMarvel heroMarvel) {
        marvelRepositoryLocalData.updateHeroesMarvel(heroMarvel);
    }

    public void deleteHeroMarvel(HeroMarvel heroMarvel) {
        marvelRepositoryLocalData.deleteHeroesMarvel(heroMarvel);
    }

}
