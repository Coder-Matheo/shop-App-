package com.shopapp.Display.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ArrayList<Fragment> lstFragments = new ArrayList<>();
    public ArrayList<String> lstTitle = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return lstFragments.get(position);
    }

    @Override
    public int getCount() {
        return lstTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitle.get(position);
    }

    public void addFragment(Fragment fragment, String s){
        lstFragments.add(fragment);
        lstTitle.add(s);
    }
}
