package com.meteorsoftech.slidingtablayoutsqlitedemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Delete on 9/16/2017.
 */

public class Pager extends FragmentStatePagerAdapter{

    int tabCount;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                Fragment_Add fragmentAdd = new Fragment_Add();
                return fragmentAdd;
            case 1:
                Fragment_Dataview fragmentView = new Fragment_Dataview();
                return fragmentView;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
