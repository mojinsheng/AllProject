package com.from.start.ui.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.from.start.R;
import com.from.start.ui.adapter.MyRVAdapter;
import com.xslong.xslonglib.base.BaseFragment;
import com.xslong.xslonglib.base.BasePresenter;

import butterknife.BindView;


public class MainFragment extends BaseFragment /*implements MainConstract.View*/ {

    @BindView(R.id.rv_main)
    RecyclerView mRvMain;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_main;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {

// 设置布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRvMain.setLayoutManager(linearLayoutManager);
        MyRVAdapter adapter=new MyRVAdapter(getActivity());
        mRvMain.setAdapter(adapter);
        Log.i("mojin","=======================================");
    }
}
