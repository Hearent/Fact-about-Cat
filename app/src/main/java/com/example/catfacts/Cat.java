package com.example.catfacts;

import com.google.gson.annotations.SerializedName;

public class Cat {
    @SerializedName("fact")
    String catFacts;
    @SerializedName("length")
    Integer factsLength;

    public Cat(String catFacts, Integer factsLength) {
        this.catFacts = catFacts;
        this.factsLength = factsLength;
    }

    public String getCatFacts() {
        return catFacts;
    }

    public Integer getFactsLength() {
        return factsLength;
    }
}
