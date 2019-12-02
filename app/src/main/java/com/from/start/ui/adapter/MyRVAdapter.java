package com.from.start.ui.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.from.start.R;
import com.from.start.ui.fragment.MainFragment;
import com.xslong.xslonglib.adapter.BaseViewHolder;

import java.util.ArrayList;

public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.MyTVHolder> {

    private boolean isFlag = true;
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private final ArrayList<String> mData;
    private final ArrayList<String> mDatas;

    public MyRVAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;

        mData = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mData.add("hello " + i);
        }
        mDatas = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            mDatas.add("hello " + i);
        }
    }


    @Override
    public MyRVAdapter.MyTVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyRVAdapter.MyTVHolder(mLayoutInflater.inflate(R.layout.muen_list, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyRVAdapter.MyTVHolder holder, int pos) {
        GridLayoutManager linearLayoutManager = new GridLayoutManager(mContext, 4);
        holder.gridLayout.addItemDecoration(new GridDividerItemDecoration(1, mContext.getResources().getColor(R.color.color_main_gary)));
        if (mDatas.size() > 8) {
            holder.gridLayout.setLayoutManager(linearLayoutManager);
            CommentAdapter adapter = new CommentAdapter(mContext, mDatas.subList(0, 8));
            holder.gridLayout.setAdapter(adapter);
            holder.l_up.setVisibility(View.VISIBLE);
            holder.imageView.setBackgroundResource(R.mipmap.img_up);

        } else {
            holder.gridLayout.setLayoutManager(linearLayoutManager);
            CommentAdapter adapter = new CommentAdapter(mContext, mDatas);
            holder.gridLayout.setAdapter(adapter);
            holder.l_up.setVisibility(View.GONE);
        }

        holder.l_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.gridLayout.setLayoutManager(linearLayoutManager);
                CommentAdapter adapter = new CommentAdapter(mContext, mDatas);
                holder.gridLayout.setAdapter(adapter);
                holder.l_up.setVisibility(View.GONE);
                holder.l_dwon.setVisibility(View.VISIBLE);
            }
        });
        holder.l_dwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.gridLayout.setLayoutManager(linearLayoutManager);
                CommentAdapter adapter = new CommentAdapter(mContext, mDatas.subList(0, 8));
                holder.gridLayout.setAdapter(adapter);
                holder.l_up.setVisibility(View.VISIBLE);
                holder.l_dwon.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    class MyTVHolder extends RecyclerView.ViewHolder {
        RecyclerView gridLayout;
        TextView text_more;
        LinearLayout l_up;
        LinearLayout l_dwon;
        ImageView imageView;

        MyTVHolder(View itemView) {
            super(itemView);
            gridLayout = (RecyclerView) itemView.findViewById(R.id.app_main);
            text_more = (TextView) itemView.findViewById(R.id.text_more);
            l_up = itemView.findViewById(R.id.l_up);
            l_dwon = itemView.findViewById(R.id.l_dwon);
            imageView = itemView.findViewById(R.id.img_down);

        }
    }


}

