package com.shopapp.Display.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shopapp.Display.RecyclerItemClickInterface;
import com.shopapp.Display.model.ItemCategory;
import com.shopapp.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryItemRecyclerAdapter extends RecyclerView.Adapter<CategoryItemRecyclerAdapter.CategoryItemViewHolder> {

    Context context;
    public List<ItemCategory> itemCategoryList = new ArrayList<>();
    RecyclerItemClickInterface recyclerItemClickInterface;


    public CategoryItemRecyclerAdapter(Context context, List<ItemCategory> itemCategoryList, RecyclerItemClickInterface recyclerItemClickInterface1) {
        this.context = context;
        this.itemCategoryList = itemCategoryList;
        this.recyclerItemClickInterface = recyclerItemClickInterface1;
    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_item, parent, false);

        CategoryItemViewHolder categoryItemViewHolder = new CategoryItemViewHolder(view);

        return categoryItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemViewHolder holder, int position) {
        holder.item_imageView.setImageResource(itemCategoryList.get(position).getImage());
        holder.name_songTextView.setText(itemCategoryList.get(position).getName_song());
    }

    @Override
    public int getItemCount() {
        return itemCategoryList.size();
    }

    public class CategoryItemViewHolder extends RecyclerView.ViewHolder{
        ImageView item_imageView;
        TextView name_songTextView;
        LinearLayout linearLayout_horizontal_item;

        public CategoryItemViewHolder(@NonNull View itemView) {
            super(itemView);
            item_imageView = itemView.findViewById(R.id.image_row_item);
            name_songTextView = itemView.findViewById(R.id.name_of_song_underbox);
            linearLayout_horizontal_item = itemView.findViewById(R.id.linearLayout_horizontal_item);



            linearLayout_horizontal_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerItemClickInterface.onItemClickInterface(getAdapterPosition());
                    //Log.i("TAG", "onClick Item: "+  " : "+ getAdapterPosition() + " : " +itemCategoryList );



                }
            });


        }

    }
}
