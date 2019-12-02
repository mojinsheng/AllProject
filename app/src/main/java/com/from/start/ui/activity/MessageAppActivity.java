package com.from.start.ui.activity;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.from.start.R;
import com.from.start.base.BaseTitleActivity;
import com.from.start.ui.adapter.MainFragmentPagerAdapter;
import com.xslong.xslonglib.base.BaseFragment;
import com.xslong.xslonglib.base.BasePresenter;

import butterknife.BindView;

/*
应用管理
 */
public class MessageAppActivity extends BaseTitleActivity {

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    private MainFragmentPagerAdapter mAdapter;

    @Override
    protected int getSubLayoutId() {
        return R.layout.fragment_app;
    }

    @Override
    protected void initData() {
        setBarTitle(View.VISIBLE,"应用管理");
        mAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), mContext);
        Log.i("mojin","======================"+mAdapter);
        mViewpager.setAdapter(mAdapter);
        mViewpager.setOffscreenPageLimit(6);
        mTabLayout.setupWithViewPager(mViewpager);
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }


}
