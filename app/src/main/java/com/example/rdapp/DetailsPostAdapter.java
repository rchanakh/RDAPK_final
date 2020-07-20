package com.example.rdapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailsPostAdapter extends RecyclerView.Adapter<DetailsPostAdapter.MyViewHolder> {

    ArrayList<MonthPaid> list;
    public DetailsPostAdapter(ArrayList<MonthPaid> list)
    {
        this.list = list;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_3,parent,false);
        //return new MyViewHolder(view);

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_3, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.accNo1.setText(list.get(position).getAccNo());
        holder.month3.setText(list.get(position).getMonth3());
        holder.amount.setText(list.get(position).getAmount());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView accNo1, month3, amount;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            accNo1 = itemView.findViewById(R.id.acc_no3);
            month3 = itemView.findViewById(R.id.month3);
            amount = itemView.findViewById(R.id.Amount3);

        }
    }
}




















