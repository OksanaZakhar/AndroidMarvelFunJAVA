package com.ksusha.vel.marvelfanj.presentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ksusha.vel.marvelfanj.data.remotedata.model.Result;
import com.ksusha.vel.marvelfanj.data.remotedata.repository.MarvelRepository;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MarvelRepository marvelRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        marvelRepository = new MarvelRepository();
    }

    public LiveData<List<Result>> getAllMarvelHero() throws NoSuchAlgorithmException {

        return marvelRepository.getMutableLiveData();
    }
}
