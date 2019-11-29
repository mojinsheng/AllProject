package com.from.start.ui.activity;

import android.view.View;

import com.from.start.R;
import com.from.start.base.BaseTitleActivity;
import com.xslong.xslonglib.base.BasePresenter;

public class WifiActivity extends BaseTitleActivity {
    @Override
    protected int getSubLayoutId() {
        return R.layout.activity_ip;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        setBarTitle(View.VISIBLE,"网络状态");
    }
}
