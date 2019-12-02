package com.from.start.ui.fragment;


import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.from.start.R;
import com.from.start.ui.activity.MainActivity;
import com.from.start.ui.activity.SearchActivity;
import com.from.start.ui.adapter.MyRVAdapter;
import com.xslong.xslonglib.base.BaseFragment;
import com.xslong.xslonglib.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;


public class MainFragment extends BaseFragment /*implements MainConstract.View*/ {

    @BindView(R.id.rv_main)
    RecyclerView mRvMain;

    @BindView(R.id.et_phonenumber)
    EditText et_phonenumber;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_main;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {

        // 设置布局

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRvMain.setLayoutManager(linearLayoutManager);
        mRvMain.addItemDecoration(new com.from.start.ui.adapter.SpaceItemDecoration(40));

        MyRVAdapter adapter = new MyRVAdapter(getActivity());
        mRvMain.setAdapter(adapter);

    }


    @OnClick({R.id.et_phonenumber})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.et_phonenumber :
                startActivity(SearchActivity.class);
                break;
        }
    }
}
