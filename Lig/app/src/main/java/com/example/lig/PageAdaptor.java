package com.example.lig;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdaptor extends FragmentPagerAdapter {
    String [] teamTabTitle  = {"Maçlar" , "Oyuncular"};
    Context context;

    public PageAdaptor(FragmentManager fm  , Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            FixtureFragment fixtureFragment = new FixtureFragment();
            return  fixtureFragment;
        }
        else if(position == 1){
            PlayersFragment playersFragment = new PlayersFragment();
            return playersFragment;
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return teamTabTitle[position];
    }
}
