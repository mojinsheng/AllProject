package com.from.start.ui.activity;

import android.view.View;

import com.from.start.R;
import com.from.start.base.BaseTitleActivity;
import com.xslong.xslonglib.base.BasePresenter;

public class IPActivity extends BaseTitleActivity {
    @Override
    protected int getSubLayoutId() {
        return R.layout.activity_wifi;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        setBarTitle(View.VISIBLE,"IP设置");

    }
}
