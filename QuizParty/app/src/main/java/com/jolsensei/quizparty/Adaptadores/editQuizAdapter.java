package com.jolsensei.quizparty.Adaptadores;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class editQuizAdapter extends FragmentPagerAdapter {

    private ArrayList<android.support.v4.app.Fragment> fragments;
    private ArrayList<String> titles;


    public editQuizAdapter(android.support.v4.app.FragmentManager fm) {

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
    public android.support.v4.app.Fragment getItem(int position) {

        return fragments.get(position);
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {

        return titles.get(position);
    }

    public void addFragment(android.support.v4.app.Fragment fragment, String title){

        fragments.add(fragment);
        titles.add(title);

    }

}





