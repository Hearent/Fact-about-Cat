package com.example.catfacts;

import com.google.gson.annotations.SerializedName;

public class Cat {
    @SerializedName("fact")
    public String catFacts;
    @SerializedName("length")
    public String factsLength;

    public Cat(String catFacts, String factsLength) {
        this.catFacts = catFacts;
        this.factsLength = factsLength;
    }

    public String getCatFacts() {
        return catFacts;
    }

    public String getFactsLength() {
        return factsLength;
    }
}
