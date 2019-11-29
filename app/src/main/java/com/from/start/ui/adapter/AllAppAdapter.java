package com.from.start.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.from.start.R;

import java.util.ArrayList;

/*
应用管理
 */
public class AllAppAdapter extends RecyclerView.Adapter<AllAppAdapter.MyTVHolder>{
        private final LayoutInflater mLayoutInflater;
        private final Context mContext;
        private final ArrayList<String> mData;

        public AllAppAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
            mContext = context;

            mData = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                mData.add("hello " + i);
            }
        }

        @Override
        public AllAppAdapter.MyTVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new AllAppAdapter.MyTVHolder(mLayoutInflater.inflate(R.layout.layout_allapp, parent, false));
        }

        @Override
        public void onBindViewHolder(final AllAppAdapter.MyTVHolder holder, int pos) {



        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 : mData.size();
        }

class MyTVHolder extends RecyclerView.ViewHolder {

    MyTVHolder(View itemView) {
        super(itemView);
    }
}
}

