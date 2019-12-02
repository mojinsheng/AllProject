package com.from.start.ui.activity;

import android.view.View;
import android.widget.LinearLayout;

import com.from.start.R;
import com.from.start.base.BaseTitleActivity;
import com.from.start.ui.activity.IPActivity;
import com.from.start.ui.activity.MainActivity;
import com.from.start.ui.activity.WifiActivity;
import com.xslong.xslonglib.base.BaseFragment;
import com.xslong.xslonglib.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;


public class SettingActicity extends BaseTitleActivity {

    @BindView(R.id.l_settingip)
    LinearLayout l_settingip;

    @BindView(R.id.l_wifi)
    LinearLayout l_wifi;

    @Override
    protected int getSubLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initData() {
        setBarTitle(View.VISIBLE,"设置");

    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @OnClick({R.id.l_settingip,R.id.l_wifi})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.l_settingip :
                startActivity(IPActivity.class);
                break;
            case R.id.l_wifi :
                startActivity(WifiActivity.class);
                break;
        }
    }
}
