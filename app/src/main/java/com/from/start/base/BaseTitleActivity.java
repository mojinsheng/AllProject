package com.from.start.base;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.flyco.tablayout.SegmentTabLayout;
import com.from.start.R;
import com.xslong.xslonglib.base.BaseActivity;
import com.xslong.xslonglib.base.BasePresenter;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * @author xslong
 */
public abstract class BaseTitleActivity<T extends BasePresenter> extends BaseActivity<T> implements View.OnClickListener {
    protected RelativeLayout mContainer;
    protected DrawerLayout mDrawer;
    protected Toolbar mToolBar;
    protected TextView mTvTitle;
    protected CircleImageView mTitleLeft;
    protected TextView mTvBarRight;


    /**
     * 获取基础页面布局
     *
     * @return 布局id
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_base;
    }

    @Override
    protected void initView() {
        setTitleView();
        setContainerView();
        setWindowStatusBarColor(this, R.color.black,R.color.black);
    }

    protected void setTitleView() {
   mToolBar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mToolBar);
        mContainer = (RelativeLayout) findViewById(R.id.container);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //关闭DrawLayout的手指滑动
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);


        mTitleLeft = findViewById(R.id.img_left);
        mTitleLeft.setOnClickListener(this);
        mTvTitle = (TextView) findViewById(R.id.tv_title);

        mTvBarRight = (TextView) findViewById(R.id.tv_bar_right);
        mTvBarRight.setOnClickListener(this);
    }
    public static void setWindowStatusBarColor(Activity activity, int colorResId, int colorId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(activity.getResources().getColor(colorResId));

                //底部导航栏
                window.setNavigationBarColor(activity.getResources().getColor(colorId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setContainerView() {
        if (getSubLayoutId() != 0) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View contentView = inflater.inflate(getSubLayoutId(), null);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            contentView.setLayoutParams(layoutParams);
            mContainer.addView(contentView);
        }
    }

    protected abstract int getSubLayoutId();



    //点击间隔时间
    private final long CLICK_DELAY_TIME = 2000;
    /**
     * 后退事件
     */
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    protected void setBarRightVisible(int visible, String content) {
        mTvBarRight.setVisibility(visible);
        mTvBarRight.setText(content);
    }

    protected void setBarTitle(int visible, String content) {
        mTvTitle.setVisibility(visible);
        mTvTitle.setText(content);
    }

    protected void setBarTitle(String content) {
        mTvTitle.setVisibility(View.VISIBLE);
        mTvTitle.setText(content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_left:
                onBarLeftClick();
                break;
            default:
        }
    }

    protected void onBarRightClick() {

    }

    protected void onBarLeftClick() {
        finish();
    }
}
