package com.from.start.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ubuntu on 17-4-13.
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String tabTitles[] = new String[]{"全部","AI智能","智能管控", "布放监控", "媒体信息", "通讯服务" };

    public MainFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.getInstance().createFragment(position);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }


}
