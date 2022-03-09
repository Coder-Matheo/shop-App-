package com.shopapp.Display;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
import com.shopapp.Display.adapter.ViewPagerAdapter;
import com.shopapp.R;
import com.shopapp.RestElement.Rest_element;

public class DisplayActivity extends AppCompatActivity {

    Rest_element rest_element;
    LinearLayout layout_list_imageview_in_scroll;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        rest_element = new Rest_element(this);
        layout_list_imageview_in_scroll = findViewById(R.id.layout_list_imageview_in_scroll);

        tabLayout = findViewById(R.id.tab_layout);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewPager);






        tabLayoutViewpager();

        scollview_tobox(R.drawable.fran1, R.drawable.ic_home, "Here Click", "Only for 20 days");
        scollview_tobox(R.drawable.fran2, R.drawable.ic_home, "Here Click", "Only for 10 days");

    }

    public void scollview_tobox(int image, int iconToast, String titleToast, String textToast){
        View scrollview = getLayoutInflater().inflate(R.layout.row_item_top_scrollview_horizontal, null, false);

        ImageView imageView = scrollview.findViewById(R.id.image_row_box);

        imageView.setImageResource(image);

        LinearLayout linearlayout_topbox = scrollview.findViewById(R.id.linearlayout_topbox);
        linearlayout_topbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rest_element.toast_makeAlert(titleToast, textToast, iconToast);
            }
        });

        layout_list_imageview_in_scroll.addView(scrollview);
    }


    public void tabLayoutViewpager(){
        viewPagerAdapter.addFragment(new ManShopFragment(), "Woman ");
        viewPagerAdapter.addFragment(new ManShopFragment(), "Man ");
        viewPagerAdapter.addFragment(new ManShopFragment(), "Man ");
        viewPagerAdapter.addFragment(new ManShopFragment(), "Man ");
        viewPagerAdapter.addFragment(new ManShopFragment(), "Man ");
        viewPagerAdapter.addFragment(new ManShopFragment(), "Man ");
        viewPagerAdapter.addFragment(new ManShopFragment(), "Man ");


        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_woman);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_man);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_man);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_man);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_man);
        tabLayout.getTabAt(5).setIcon(R.drawable.ic_man);
    }






}