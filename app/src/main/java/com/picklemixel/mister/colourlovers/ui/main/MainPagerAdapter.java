package com.picklemixel.mister.colourlovers.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.picklemixel.mister.colourlovers.ui.explore.PalettesListFragment;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 11/10/2016.
 */
class MainPagerAdapter extends FragmentPagerAdapter {

    MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PalettesListFragment.newInstance(PalettesListFragment.TYPE_TOP);
            case 1:
                return PalettesListFragment.newInstance(PalettesListFragment.TYPE_NEW);
        }
        return PalettesListFragment.newInstance(PalettesListFragment.TYPE_TOP);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "TOP";
            case 1:
                return "NEW";
        }
        return "TOP";
    }
}
