package com.shopapp.Display.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shopapp.Display.model.ItemCategory;

import java.util.List;

public class DetailRecyclerAdapter extends RecyclerView.Adapter<DetailRecyclerAdapter.DetailViewHolder> {
    Context context;
    private List<String> detailItemCategoryList;

    public DetailRecyclerAdapter(Context context, List<String> detailItemCategoryList) {
        this.context = context;
        this.detailItemCategoryList = detailItemCategoryList;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder{
        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
