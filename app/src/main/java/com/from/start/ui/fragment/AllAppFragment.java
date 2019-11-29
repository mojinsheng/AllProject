package com.from.start.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.from.start.R;
import com.from.start.ui.adapter.AllAppAdapter;
import com.from.start.ui.adapter.MyRVAdapter;
import com.xslong.xslonglib.base.BaseFragment;
import com.xslong.xslonglib.base.BasePresenter;

import butterknife.BindView;

/*
应用管理
 */
public class AllAppFragment extends BaseFragment {
    @BindView(R.id.rv_allapp)
    RecyclerView rv_allapp;
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_allapp;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv_allapp.setLayoutManager(linearLayoutManager);
        AllAppAdapter adapter=new AllAppAdapter(getActivity());
        rv_allapp.setAdapter(adapter);
    }
}
