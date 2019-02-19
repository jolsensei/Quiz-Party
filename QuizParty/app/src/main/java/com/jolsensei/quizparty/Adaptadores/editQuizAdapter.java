package com.jolsensei.quizparty.Adaptadores;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class editQuizAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;


    public editQuizAdapter(FragmentManager fm) {

        super(fm);
        this.fragments = new ArrayList<>();
        this.titles = new ArrayList<>();
    }

    // Returns total number of pages
    @Override
    public int getCount() {

        return fragments.size();
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {

        return titles.get(position);
    }

    public void addFragment(Fragment fragment, String title){

        fragments.add(fragment);
        titles.add(title);

    }

}





