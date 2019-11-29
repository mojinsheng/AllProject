package com.from.start.ui.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.from.start.R;
import com.from.start.ui.fragment.MainFragment;
import com.xslong.xslonglib.adapter.BaseViewHolder;

import java.util.ArrayList;

public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.MyTVHolder>{
        private final LayoutInflater mLayoutInflater;
        private final Context mContext;
        private final ArrayList<String> mData;

        public MyRVAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
            mContext = context;

            mData = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                mData.add("hello " + i);
            }
        }




        @Override
        public MyRVAdapter.MyTVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyRVAdapter.MyTVHolder(mLayoutInflater.inflate(R.layout.muen_list, parent, false));
        }

        @Override
        public void onBindViewHolder(final MyRVAdapter.MyTVHolder holder, int pos) {

            GridLayoutManager linearLayoutManager = new GridLayoutManager(mContext,4);
            holder.gridLayout.addItemDecoration(new GridDividerItemDecoration(1,mContext.getResources().getColor(R.color.color_main_gary)));

            holder.gridLayout.setLayoutManager(linearLayoutManager);
            CommentAdapter adapter=new CommentAdapter(mContext);
            holder.gridLayout.setAdapter(adapter);




        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 : mData.size();
        }

    class MyTVHolder extends RecyclerView.ViewHolder {
    RecyclerView gridLayout;

    MyTVHolder(View itemView) {
        super(itemView);
        gridLayout = (RecyclerView)itemView.findViewById(R.id.app_main);

    }
    }
    class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        int mSpace;
        public SpaceItemDecoration(int space) {
            this.mSpace = space;
        }
        private int space;



        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left = space;
            outRect.bottom = space;
            //由于每行都只有3个，所以第一个都是3的倍数，把左边距设为0
            if (parent.getChildLayoutPosition(view) %3==0) {
                outRect.left = 0;
            }

        }
    }
}

