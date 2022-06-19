package com.ksusha.vel.marvelfanj.data.remotedata.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Comics {

    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<>();

    public Comics(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
