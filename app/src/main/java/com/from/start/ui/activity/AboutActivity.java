package com.from.start.ui.activity;

import android.view.View;

import com.from.start.R;
import com.from.start.base.BaseTitleActivity;
import com.xslong.xslonglib.base.BasePresenter;

public class AboutActivity extends BaseTitleActivity {
    @Override
    protected int getSubLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        setBarTitle(View.VISIBLE,"关于");

    }
}
