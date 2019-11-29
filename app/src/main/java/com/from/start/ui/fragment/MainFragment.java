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

import com.from.start.R;
import com.from.start.ui.adapter.MyRVAdapter;
import com.xslong.xslonglib.base.BaseFragment;
import com.xslong.xslonglib.base.BasePresenter;

import butterknife.BindView;


public class MainFragment extends BaseFragment /*implements MainConstract.View*/ {

    @BindView(R.id.rv_main)
    RecyclerView mRvMain;


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
        mRvMain.addItemDecoration(new SpaceItemDecoration(40));

        MyRVAdapter adapter = new MyRVAdapter(getActivity());
        mRvMain.setAdapter(adapter);

    }

    class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        int mSpace;
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left = mSpace;
            outRect.right = mSpace;
            outRect.bottom = mSpace;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = mSpace;
            }
        }
        public SpaceItemDecoration(int space) {
            this.mSpace = space;
        }
    }
}
