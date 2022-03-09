package com.shopapp.Display.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shopapp.Display.ManShopFragment;
import com.shopapp.Display.model.AllCategory;
import com.shopapp.R;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MyViewHolder> {
    Context context;
    List<AllCategory> data;

    public MainRecyclerViewAdapter(Context context, List<AllCategory> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titleTextView.setText(data.get(position).getName());

        ManShopFragment manShopFragment = new ManShopFragment();
        manShopFragment.setContentItemRecycler(holder.itemRecyclerView, data.get(position).getCategoryList());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        RecyclerView itemRecyclerView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            itemRecyclerView = itemView.findViewById(R.id.recyclerview_item_id);

        }
    }
}
