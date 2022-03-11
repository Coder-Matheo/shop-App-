package com.shopapp.Display.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shopapp.Display.model.ItemCategory;
import com.shopapp.Display.model.descriptionModel;
import com.shopapp.R;

import java.util.List;

public class DetailRecyclerAdapter extends RecyclerView.Adapter<DetailRecyclerAdapter.DetailViewHolder> {
    Context context;
    private List<descriptionModel> detailItemCategoryList;

    public DetailRecyclerAdapter(Context context, List<descriptionModel> detailItemCategoryList) {
        this.context = context;
        this.detailItemCategoryList = detailItemCategoryList;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_detail_recycler_item, parent, false);

        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        holder.title_detail_item_row_text.setText(detailItemCategoryList.get(position).getTitleDetail());
        holder.desc_detail_item_row_text.setText(detailItemCategoryList.get(position).getDescriptionDetail());
    }

    @Override
    public int getItemCount() {
        return detailItemCategoryList.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder{
        TextView title_detail_item_row_text;
        TextView desc_detail_item_row_text;
        LinearLayout color1;
        LinearLayout color2;
        LinearLayout color3;
        LinearLayout color4;

        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            title_detail_item_row_text = itemView.findViewById(R.id.title_detail_item_row_text);
            desc_detail_item_row_text = itemView.findViewById(R.id.desc_detail_item_row_text);
            color1 = itemView.findViewById(R.id.color1id);
            color2 = itemView.findViewById(R.id.color2id);
            color3 = itemView.findViewById(R.id.color3id);
            color4 = itemView.findViewById(R.id.color4id);
        }
    }
}
