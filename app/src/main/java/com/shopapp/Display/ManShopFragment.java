package com.shopapp.Display;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
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
import com.shopapp.Display.DetailDisplay.DetailDisplayActivity;
import com.shopapp.R;
import java.util.ArrayList;
import java.util.List;

public class ManShopFragment extends Fragment implements RecyclerItemClickInterface, RecyclerMainItemClickInterface{

    RecyclerView recyclerViewDisplay;
    List<AllCategory> lstOfPriceName;
    Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_man_shop, container, false);


        List<ItemCategory> categoryItemList = new ArrayList<>();
        categoryItemList.add(new ItemCategory(R.drawable.fran1, "AAA"));
        categoryItemList.add(new ItemCategory(R.drawable.fran1, "AAA"));
        categoryItemList.add(new ItemCategory(R.drawable.fran3, "AAA"));
        categoryItemList.add(new ItemCategory(R.drawable.fran2, "AAA"));

        List<ItemCategory> categoryItemList2 = new ArrayList<>();
        categoryItemList2.add(new ItemCategory(R.drawable.fran4, "BBB"));
        categoryItemList2.add(new ItemCategory(R.drawable.fran2, "BBB"));
        categoryItemList2.add(new ItemCategory(R.drawable.fran1, "BBB"));
        categoryItemList2.add(new ItemCategory(R.drawable.fran3, "BBB"));

        List<ItemCategory> categoryItemList3 = new ArrayList<>();
        categoryItemList3.add(new ItemCategory(R.drawable.fran2, "CCC"));
        categoryItemList3.add(new ItemCategory(R.drawable.fran1, "CCC"));
        categoryItemList3.add(new ItemCategory(R.drawable.fran3, "CCC"));
        categoryItemList3.add(new ItemCategory(R.drawable.fran1, "CCC"));


        lstOfPriceName = new ArrayList<>();
        lstOfPriceName.add(new AllCategory("Matheo", "Dina", 22, categoryItemList));
        lstOfPriceName.add(new AllCategory("Ali", "Dina", 30, categoryItemList2));
        lstOfPriceName.add(new AllCategory("Hako", "Dina", 49, categoryItemList3));
        lstOfPriceName.add(new AllCategory("Kauko", "Dina", 60, categoryItemList));
        setContentMainRecycler(view);
        return view;
    }


    private void setContentMainRecycler(View view) {
        recyclerViewDisplay = view.findViewById(R.id.recyclerview_display_id);
        MainRecyclerViewAdapter mainRecyclerViewAdapter = new MainRecyclerViewAdapter(getContext(), lstOfPriceName, this::onMainItemClickInterface);
        recyclerViewDisplay.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewDisplay.setAdapter(mainRecyclerViewAdapter);
    }

    public void setContentItemRecycler(RecyclerView recyclerView, List<ItemCategory> itemCategoryList) {
        CategoryItemRecyclerAdapter itemRecyclerAdapter = new CategoryItemRecyclerAdapter(context, itemCategoryList, this::onItemClickInterface);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(itemRecyclerAdapter);
    }

    @Override
    public void onItemClickInterface(int position) {
        Log.i("TAG", "onItemClickInterface: Item man Shop"+position);
    }


    @Override
    public void onMainItemClickInterface(int position, List<ItemCategory> itemDetailCategoryList) {

        Log.i("TAG", "onMainItemClickInterface: Main Main man Shop "+ itemDetailCategoryList.get(position).getName_song());

        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> image = new ArrayList<>();

        for (int i = 0; i <itemDetailCategoryList.size(); i++){
            name.add(itemDetailCategoryList.get(i).getName_song());
            image.add(itemDetailCategoryList.get(i).getImage());
        }

        Intent intent = new Intent(getActivity().getApplicationContext(), DetailDisplayActivity.class);

        intent.putExtra("name", name);
        intent.putExtra("image", image);
        startActivity(intent);
    }


}