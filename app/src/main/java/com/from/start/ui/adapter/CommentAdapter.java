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

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.AppHolder> {

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private final ArrayList<String> mData;

    public CommentAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;

        mData = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mData.add("hello " + i);
        }
    }

    @NonNull
    @Override
    public CommentAdapter.AppHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommentAdapter.AppHolder(mLayoutInflater.inflate(R.layout.layout_itempp, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.AppHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class AppHolder extends RecyclerView.ViewHolder {
        TextView textView;

        AppHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.text);
        }
    }

}
