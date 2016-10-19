package com.ccw.qqmusic.showMusic.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/19 0019.
 */

public class RvAdapter<T> extends RecyclerView.Adapter {
    private Context context;
    private List<T> list;
    private LayoutInflater inflater;
    private int layoutResId;
    private int variableId;

    public RvAdapter(Context context, List<T> list, int layoutResId, int variableId) {
        this.context = context;
        this.list = list;
        this.layoutResId = layoutResId;
        this.variableId = variableId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutResId, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).getDataBinding().setVariable(variableId, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding dataBinding;

        public MyViewHolder(ViewDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }

        public ViewDataBinding getDataBinding() {
            return dataBinding;
        }
    }
}
