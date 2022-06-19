package com.ksusha.vel.marvelfanj.data.remotedata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MarvelApiResponse {


    @SerializedName("data")
    @Expose
    private Data data;

    public MarvelApiResponse(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
