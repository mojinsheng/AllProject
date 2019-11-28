package com.from.start.ui.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.from.start.R;
import com.from.start.ui.activity.IPActivity;
import com.from.start.ui.activity.MainActivity;
import com.from.start.ui.activity.WifiActivity;
import com.xslong.xslonglib.base.BaseFragment;
import com.xslong.xslonglib.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;


public class SettingFragment extends BaseFragment{

    @BindView(R.id.l_settingip)
    LinearLayout l_settingip;

    @BindView(R.id.l_wifi)
    LinearLayout l_wifi;





    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_setting;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {

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
