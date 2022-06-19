package com.ksusha.vel.marvelfanj.data.remotedata.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://gateway.marvel.com/";

    public static MarvelApiService getService() {

        if (retrofit == null) {

            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        MarvelApiService service = retrofit.create(MarvelApiService.class);
        return service;

    }


}
