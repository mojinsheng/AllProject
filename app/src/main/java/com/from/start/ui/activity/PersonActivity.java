package com.from.start.ui.activity;

import android.view.View;
import android.widget.LinearLayout;

import com.from.start.R;
import com.from.start.base.BaseTitleActivity;
import com.from.start.ui.activity.AboutActivity;
import com.from.start.ui.activity.IPActivity;
import com.from.start.ui.activity.WifiActivity;
import com.xslong.xslonglib.base.BaseFragment;
import com.xslong.xslonglib.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;


public class PersonActivity extends BaseTitleActivity {

    @BindView(R.id.l_about)
    LinearLayout l_about;

    @Override
    protected int getSubLayoutId() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initData() {
        setBarTitle(View.VISIBLE,"用户中心");

    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @OnClick({R.id.l_about})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.l_about :
                startActivity(AboutActivity.class);
                break;

        }
    }
}
