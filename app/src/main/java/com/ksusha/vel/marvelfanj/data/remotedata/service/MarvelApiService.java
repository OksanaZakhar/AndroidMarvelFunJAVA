package com.ksusha.vel.marvelfanj.data.remotedata.service;

import com.ksusha.vel.marvelfanj.data.remotedata.model.MarvelApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelApiService {

    @GET("v1/public/characters")
    Call<MarvelApiResponse> getMarvel(
            @Query("limit") int limit,
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash);


}
