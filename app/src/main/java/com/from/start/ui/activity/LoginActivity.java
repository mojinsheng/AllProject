package com.from.start.ui.activity;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.from.start.R;
import com.from.start.base.BaseTitleActivity;
import com.xslong.xslonglib.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;


public class LoginActivity extends BaseTitleActivity  {

    @BindView(R.id.btn_login)
    ImageView btn_login;

    @Override
    protected int getSubLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        mToolBar.setVisibility(View.GONE);
    }
    @OnClick({R.id.btn_login})
    public void OnClick(View view){
            switch (view.getId()){
                case R.id.btn_login :

                    startActivity(MainActivity.class);
                    break;
            }
    }
}
