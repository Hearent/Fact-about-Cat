package com.example.catfacts;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatList {
    @SerializedName("data")
    private List<Cat> cat;

    public List<Cat> getCat() {
        return cat;
    }

    public CatList(List<Cat> cat) {
        this.cat = cat;
    }
}
