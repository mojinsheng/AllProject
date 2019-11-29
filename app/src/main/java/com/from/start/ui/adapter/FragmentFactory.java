package com.from.start.ui.adapter;

import android.support.v4.app.Fragment;

import com.from.start.ui.fragment.AllAppFragment;

/**
 * Created by ubuntu on 17-4-13.
 */

public class FragmentFactory {
    private static FragmentFactory instance;

    public static synchronized FragmentFactory getInstance() {
        if (instance == null) {
            instance = new FragmentFactory();
        }

        return instance;
    }

    public Fragment createFragment(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = new AllAppFragment();
                break;
            case 1:
                fragment =  new AllAppFragment();
                break;
            case 2:
                fragment =  new AllAppFragment();
                break;
            case 3:
                fragment =  new AllAppFragment();
                break;
            case 4:
                fragment =  new AllAppFragment();
                break;
            case 5:
                fragment =  new AllAppFragment();
                break;
        }
        return fragment;
    }

}
