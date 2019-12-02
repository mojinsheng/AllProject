package com.from.start.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.from.start.R;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {


    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private List<String> mDatas=new ArrayList<>();

    public SearchAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
        mDatas = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            mDatas.add("hello " + i);
        }
    }

    @NonNull
    @Override
    public SearchAdapter.SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchAdapter.SearchHolder(mLayoutInflater.inflate(R.layout.layout_search, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class SearchHolder extends RecyclerView.ViewHolder {
        TextView textView;

        SearchHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.search_lishi);
        }
    }
}
