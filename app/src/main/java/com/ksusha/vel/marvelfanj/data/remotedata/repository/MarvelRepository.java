package com.ksusha.vel.marvelfanj.data.remotedata.repository;

import androidx.lifecycle.MutableLiveData;

import com.ksusha.vel.marvelfanj.data.remotedata.model.MarvelApiResponse;
import com.ksusha.vel.marvelfanj.data.remotedata.model.Result;
import com.ksusha.vel.marvelfanj.data.remotedata.service.MarvelApiService;
import com.ksusha.vel.marvelfanj.data.remotedata.service.ParamsResponseKye;
import com.ksusha.vel.marvelfanj.data.remotedata.service.RetrofitInstance;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarvelRepository {

    private ArrayList<Result> results = new ArrayList<>();

    private MutableLiveData<List<Result>> mutableLiveData =
            new MutableLiveData<>();

    public MutableLiveData<List<Result>> getMutableLiveData() throws NoSuchAlgorithmException {

        MarvelApiService marvelApiService = RetrofitInstance.getService();

        Call<MarvelApiResponse> call = marvelApiService.getMarvel(
                10,
                ParamsResponseKye.getTimestamp(),
                ParamsResponseKye.API_KEY,
                ParamsResponseKye.getHash()
        );


        call.enqueue(new Callback<MarvelApiResponse>() {
            @Override
            public void onResponse(Call<MarvelApiResponse> call,
                                   Response<MarvelApiResponse> response) {

                MarvelApiResponse marvelApiResponse = response.body();

                if (marvelApiResponse != null && marvelApiResponse.getData().getResults() != null) {

                    results = (ArrayList<Result>) marvelApiResponse.getData().getResults();
                    mutableLiveData.setValue(results);
                }
            }

            @Override
            public void onFailure(Call<MarvelApiResponse> call, Throwable t) {

            }
        });
        return mutableLiveData;

    }


}
