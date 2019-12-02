package com.from.start.ui.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.from.start.R;
import com.from.start.base.BaseTitleActivity;
import com.from.start.ui.adapter.AllAppAdapter;
import com.from.start.ui.adapter.MyRVAdapter;
import com.from.start.ui.adapter.SearchAdapter;
import com.from.start.ui.adapter.SearchAppAdapter;
import com.from.start.ui.adapter.SearchItemDecoration;
import com.from.start.ui.adapter.SpaceItemDecoration;
import com.from.start.ui.fragment.MainFragment;
import com.xslong.xslonglib.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchActivity extends BaseTitleActivity {

    @BindView(R.id.search_main)
    RecyclerView search_main;

    @BindView(R.id.search_app)
    RecyclerView search_app;

    @BindView(R.id.l_searchapp)
    LinearLayout l_searchapp;

    @BindView(R.id.text_search)
    TextView text_search;

    @BindView(R.id.l_lishi)
    LinearLayout l_lishi;

    @Override
    protected int getSubLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
    @OnClick({R.id.text_search,R.id.l_searchapp})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.text_search :
                l_lishi.setVisibility(View.GONE);
                l_searchapp.setVisibility(View.VISIBLE);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                search_app.setLayoutManager(linearLayoutManager);
                SearchAppAdapter adapter=new SearchAppAdapter(this);
                search_app.setAdapter(adapter);
                break;
        }
    }
    @Override
    protected void initData() {
        setBarTitle(View.VISIBLE,"搜索应用");
        GridLayoutManager linearLayoutManager = new GridLayoutManager(mContext, 6);
        search_main.setLayoutManager(linearLayoutManager);
        search_main.addItemDecoration(new SearchItemDecoration(20));
        SearchAdapter adapter = new SearchAdapter(mContext);
        search_main.setAdapter(adapter);
    }
}
