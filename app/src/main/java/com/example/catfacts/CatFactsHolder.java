package com.example.catfacts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatFactsHolder {

    @GET("facts")
    Call<List<Cat>> getFacts();
}
