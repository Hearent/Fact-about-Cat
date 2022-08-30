package com.example.catfacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    RecyclerView recyclerView;
    MyAdapter adapter;
    CatFactsHolder catFactsHolder;
    ArrayList<String> facts = new ArrayList<>();
    ArrayList<String> length = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress_circular);

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://catfact.ninja/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        catFactsHolder = retrofit.create(CatFactsHolder.class);

        getFact();
    }

    private void getFact() {
        Call<CatList> call = catFactsHolder.getFact();

        call.enqueue(new Callback<CatList>() {
            @Override
            public void onResponse(Call<CatList> call, Response<CatList> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Coś poszło nie tak "+response.code(), Toast.LENGTH_SHORT).show();
                } else {
                    List<Cat> cats = response.body().getCat();
                    for (Cat cat : cats){
                        facts.add(cat.getCatFacts());
                        length.add(cat.getFactsLength().toString());
                    }
                    recyclerView = findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    adapter = new MyAdapter(facts, length);
                    recyclerView.setAdapter(adapter);
                    progressBar.setEnabled(false);
                }
            }

            @Override
            public void onFailure(Call<CatList> call, Throwable t) {
            }
        });
    }
}