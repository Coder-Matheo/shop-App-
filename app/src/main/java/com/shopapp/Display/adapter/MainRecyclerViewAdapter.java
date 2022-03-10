package com.shopapp.Display.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shopapp.Display.ManShopFragment;
import com.shopapp.Display.RecyclerItemClickInterface;
import com.shopapp.Display.RecyclerMainItemClickInterface;
import com.shopapp.Display.model.AllCategory;
import com.shopapp.Display.model.ItemCategory;
import com.shopapp.R;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MyViewHolder> {
    Context context;
    public List<AllCategory> data;

    RecyclerMainItemClickInterface recyclerMainItemClickInterface;

    public MainRecyclerViewAdapter(Context context, List<AllCategory> data, RecyclerMainItemClickInterface recyclerMainItemClickInterface1) {
        this.context = context;
        this.data = data;
        this.recyclerMainItemClickInterface = recyclerMainItemClickInterface1;

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

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        RecyclerView itemRecyclerView;
        Button more_main_recycler_button;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            itemRecyclerView = itemView.findViewById(R.id.recyclerview_item_id);
            more_main_recycler_button = itemView.findViewById(R.id.more_main_recycler_button);


            more_main_recycler_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("TAG", "onClick: " + getAdapterPosition() + " : " + titleTextView.getText().toString());
                    Log.i("TAG", "onClick Item: " + data.get(getAdapterPosition()).getCategoryList().get(getAdapterPosition()));
                    Log.i("TAG", "onClick Item: " + data.get(getAdapterPosition()).getCategoryList());

                    recyclerMainItemClickInterface.onMainItemClickInterface(getAdapterPosition(), data.get(getAdapterPosition()).getCategoryList());

                }
            });
        }

    }
}
