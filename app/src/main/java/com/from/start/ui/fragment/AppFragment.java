package com.from.start.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.from.start.R;
import com.from.start.ui.adapter.MainFragmentPagerAdapter;
import com.xslong.xslonglib.base.BaseFragment;
import com.xslong.xslonglib.base.BasePresenter;

import butterknife.BindView;

/*
应用管理
 */
public class AppFragment extends BaseFragment {

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    private MainFragmentPagerAdapter mAdapter;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_app;
    }


    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        mAdapter = new MainFragmentPagerAdapter(getActivity().getSupportFragmentManager(), getActivity());
        mViewpager.setAdapter(mAdapter);
        mViewpager.setOffscreenPageLimit(6);
        mTabLayout.setupWithViewPager(mViewpager);
    }


}
