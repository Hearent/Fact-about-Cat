package com.example.catfacts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatFactsHolder {

    @GET("facts")
    Call<CatList> getFact();
}
