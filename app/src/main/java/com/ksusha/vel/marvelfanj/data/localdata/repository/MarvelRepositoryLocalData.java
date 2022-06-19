package com.ksusha.vel.marvelfanj.data.localdata.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.ksusha.vel.marvelfanj.data.localdata.HeroMarvel;
import com.ksusha.vel.marvelfanj.data.localdata.HeroesMarvelDAO;
import com.ksusha.vel.marvelfanj.data.localdata.HeroesMarvelDataBase;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MarvelRepositoryLocalData {

    private HeroesMarvelDAO heroesMarvelDAO;
    private LiveData<List<HeroMarvel>> heroes;

    public MarvelRepositoryLocalData(Application application) {
        HeroesMarvelDataBase dataBase = HeroesMarvelDataBase.getInstance(application);
        heroesMarvelDAO = dataBase.getHeroesMarvelDAO();
    }

    public LiveData<List<HeroMarvel>> getHeroMarvel() {

        return heroesMarvelDAO.getAllHeroesMarvel();
    }

    public void insertHeroesMarvel(HeroMarvel heroMarvel) {

        Observable.create(new ObservableOnSubscribe<Object>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                        heroesMarvelDAO.insertHeroMarvel(heroMarvel);
                    }
                }).subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }

    public void updateHeroesMarvel(HeroMarvel heroMarvel) {

        Observable.create(new ObservableOnSubscribe<Object>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                        heroesMarvelDAO.updateHeroMarvel(heroMarvel);
                    }
                }).subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }

    public void deleteHeroesMarvel(HeroMarvel heroMarvel) {
        Observable.create(new ObservableOnSubscribe<Object>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                        heroesMarvelDAO.deleteHeroMarvel(heroMarvel);
                    }
                }).subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }

    public LiveData<List<String>> getAllIdHeroMarvel() {

        return heroesMarvelDAO.getAllIdHeroesMarvel();
    }


}














