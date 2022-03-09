package com.shopapp.Display;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shopapp.Display.adapter.CategoryItemRecyclerAdapter;
import com.shopapp.Display.adapter.MainRecyclerViewAdapter;
import com.shopapp.Display.model.AllCategory;
import com.shopapp.Display.model.ItemCategory;
import com.shopapp.R;

import java.util.ArrayList;
import java.util.List;

public class ManShopFragment extends Fragment {

    RecyclerView recyclerViewDisplay;
    List<AllCategory> lstOfPriceName;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_man_shop, container, false);


        List<ItemCategory> categoryItemList = new ArrayList<>();
        categoryItemList.add(new ItemCategory( R.drawable.fran1,"Hall"));
        categoryItemList.add(new ItemCategory( R.drawable.fran2,"Hall1"));
        categoryItemList.add(new ItemCategory( R.drawable.fran3,"Hall2"));
        categoryItemList.add(new ItemCategory( R.drawable.fran4,"Hall3"));
        categoryItemList.add(new ItemCategory( R.drawable.fran1,"Hall4"));
        categoryItemList.add(new ItemCategory( R.drawable.fran2,"Hall5"));
        categoryItemList.add(new ItemCategory( R.drawable.fran3,"Hall6"));
        categoryItemList.add(new ItemCategory( R.drawable.fran4,"Hall7"));

        lstOfPriceName = new ArrayList<>();
        lstOfPriceName.add(new AllCategory("Matheo", "Dina", 22, categoryItemList));
        lstOfPriceName.add(new AllCategory("Ali", "Dina", 30, categoryItemList));
        lstOfPriceName.add(new AllCategory("Hako", "Dina", 49, categoryItemList));
        lstOfPriceName.add(new AllCategory("Kauko", "Dina", 60, categoryItemList));

        setContentMainRecycler(view);

        return view;
    }

    private void setContentMainRecycler(View view){
        recyclerViewDisplay = view.findViewById(R.id.recyclerview_display_id);
        MainRecyclerViewAdapter mainRecyclerViewAdapter = new MainRecyclerViewAdapter(getContext(), lstOfPriceName);
        recyclerViewDisplay.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewDisplay.setAdapter(mainRecyclerViewAdapter);

    }


    public void setContentItemRecycler(RecyclerView recyclerView, List<ItemCategory> itemCategoryList){
        CategoryItemRecyclerAdapter itemRecyclerAdapter = new CategoryItemRecyclerAdapter(context, itemCategoryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(itemRecyclerAdapter);

    }

}
