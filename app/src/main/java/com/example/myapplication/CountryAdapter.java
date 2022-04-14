package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder>
{
    interface OnStateClickListener
    {
        void onStateClick(Country country,int position);
    }
    private LayoutInflater inflater;
    private List<Country> countries;
    private OnStateClickListener onStateClickListener;

    public CountryAdapter(List<Country> countries, Context context,OnStateClickListener onClickListener) {
        this.countries = countries;
        this.inflater=LayoutInflater.from(context);
        this.onStateClickListener=onClickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.country_list_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Country country=countries.get(position);
        holder.flag.setImageResource(country.getFlag());
        holder.name.setText(country.getName());
        holder.capital.setText(country.getCapital());
        holder.count.setText(Integer.toString(country.getCount()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onStateClickListener.onStateClick(country,position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView flag;
        TextView name,capital,count;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flag=itemView.findViewById(R.id.flag);
            name=itemView.findViewById(R.id.name);
            capital=itemView.findViewById(R.id.capital);
            count=itemView.findViewById(R.id.count);
        }
    }
}
