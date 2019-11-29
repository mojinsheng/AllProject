package com.from.start.ui.activity;




import android.Manifest;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.from.start.R;
import com.from.start.ui.fragment.MainFragment;
import com.from.start.ui.fragment.AppFragment;
import com.from.start.ui.fragment.PersonFragment;
import com.from.start.ui.fragment.SettingFragment;
import com.tbit.tbitblesdk.Bike.ResultCode;
import com.tbit.tbitblesdk.Bike.TbitBle;
import com.xslong.xslonglib.base.BaseActivity;
import com.xslong.xslonglib.base.BasePresenter;

import pub.devrel.easypermissions.EasyPermissions;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private FragmentManager manager;

    private LinearLayout l_index,l_app,l_setting,l_my;
    private boolean isIndex,isApp,isSeting,isMy;
    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    private Fragment fragment;
    private String tag;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        l_index = findViewById(R.id.l_index);
        l_app = findViewById(R.id.l_app);
        l_setting = findViewById(R.id.l_setting);
        l_my = findViewById(R.id.l_my);

        l_index.setOnClickListener(this);
        l_app.setOnClickListener(this);
        l_setting.setOnClickListener(this);
        l_my.setOnClickListener(this);

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.main_fragment, new MainFragment(), MainFragment.class.getSimpleName());
        transaction.commit();
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    private void checkPermissions() {
        String[] permissions = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission
                .ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE};
        if (EasyPermissions.hasPermissions(this, permissions)) {

        } else {
            EasyPermissions.requestPermissions(this, "地图定位需要定位权限",
                    1000, permissions);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (TbitBle.getBleConnectionState() == ResultCode.SUCCEED) {
            TbitBle.disConnect();
            TbitBle.destroy();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.l_index:
                //首页
                fragment = new MainFragment();
                tag = MainFragment.class.getSimpleName();
                startFragment(fragment,tag);
                break;
            case R.id.l_app:
                //监控
                fragment = new AppFragment();
                tag = AppFragment.class.getSimpleName();
                startFragment(fragment,tag);

                break;
            case R.id.l_setting:
                fragment = new SettingFragment();
                tag = SettingFragment.class.getSimpleName();
                startFragment(fragment,tag);

                //个人中心
                break;
            case R.id.l_my:
                fragment = new PersonFragment();
                tag = PersonFragment.class.getSimpleName();
                startFragment(fragment,tag);
                //个人中心
                break;
        }
    }

    public void startFragment(Fragment fragment,String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.setCustomAnimations(
//                R.anim.fragment_enter_go,
//                R.anim.fragment_exit_go,
//                R.anim.fragment_enter_back,
//                R.anim.fragment_exit_back);
        transaction.addToBackStack(null);
        transaction.replace(R.id.main_fragment, fragment, tag);
        transaction.commitAllowingStateLoss();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
//            hideSystemUI();
//        }
//    }
    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY //(修改这个选项，可以设置不同模式)
                        //使用下面三个参数，可以使内容显示在system bar的下面，防止system bar显示或
                        //隐藏时，Activity的大小被resize。
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // 隐藏导航栏和状态栏
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }


}
