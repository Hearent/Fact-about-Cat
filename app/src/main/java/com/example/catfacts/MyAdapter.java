package com.example.catfacts;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHoler>{
    List<String> facts;
    List<String> length;

    MyAdapter(List<String> facts, List<String> length) {
        Log.d("TAG", "MyAdapter: ");
        this.facts = facts;
        this.length = length;
    }
    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fact_row, parent, false);
        return new MyViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        holder.text_fact.setText(facts.get(position));
        holder.text_factLength.setText(length.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d("TAG", "getItemCount: ");
        return facts.size();
    }
}

class MyViewHoler extends RecyclerView.ViewHolder{

    TextView text_fact;
    TextView text_factLength;
    public MyViewHoler(@NonNull View itemView) {
        super(itemView);
        text_fact = itemView.findViewById(R.id.facts);
        text_factLength = itemView.findViewById(R.id.factsLendth);
    }
}
