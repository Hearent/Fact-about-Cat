package com.example.catfacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHoler>{
    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fact_row, parent, false);
        return new MyViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        holder.text_fact.setText("Ala ma kotaAla ma kotaAla ma kotaAla ma kotaAla ma kotaAla ma kotaAla ma kotaAla ma kota");
        holder.text_factLength.setText("11");
    }

    @Override
    public int getItemCount() {
        return 1;
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
//    public TextView get_fact(){
//        return text_fact;
//    }
//    public TextView get_factLength(){
//        return text_factLength;
//    }
}
