package com.ksusha.vel.marvelfanj.data.remotedata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Data {


    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<Result>();

    public Data(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
