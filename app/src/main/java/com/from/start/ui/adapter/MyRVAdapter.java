package com.from.start.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.from.start.R;

import java.util.ArrayList;

public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.MyTVHolder>{
        private final LayoutInflater mLayoutInflater;
        private final Context mContext;
        private final ArrayList<String> mData;

        public MyRVAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
            mContext = context;

            mData = new ArrayList<>();
            for (int i = 0; i < 40; i++) {
                mData.add("hello " + i);
            }
        }

        @Override
        public MyRVAdapter.MyTVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyRVAdapter.MyTVHolder(mLayoutInflater.inflate(R.layout.muen_list, parent, false));
        }

        @Override
        public void onBindViewHolder(final MyRVAdapter.MyTVHolder holder, int pos) {



        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 : mData.size();
        }

class MyTVHolder extends RecyclerView.ViewHolder {
    GridView gridLayout;

    MyTVHolder(View itemView) {
        super(itemView);
        gridLayout = (GridView) itemView.findViewById(R.id.gridview);
    }
}
}

