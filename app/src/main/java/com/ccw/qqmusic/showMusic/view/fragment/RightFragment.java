package com.ccw.qqmusic.showMusic.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.ccw.qqmusic.App;
import com.ccw.qqmusic.BR;
import com.ccw.qqmusic.BaseFragment;
import com.ccw.qqmusic.R;
import com.ccw.qqmusic.showMusic.model.bean.MusicBean;
import com.ccw.qqmusic.showMusic.presenter.RightPresenter;
import com.ccw.qqmusic.showMusic.view.adapter.RvAdapter;
import com.ccw.qqmusic.util.BitmapCache;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/19 0019.
 */

public class RightFragment extends BaseFragment implements IRightView {
    private RightPresenter rightPresenter = new RightPresenter(this);
    private RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.right_fg_layout, container, false);
        initView(view);
        rightPresenter.start(3);
        return view;
    }

    private void initView(View view) {
        rv = ((RecyclerView) view.findViewById(R.id.recyclerView));
    }

    @Override
    public void inRv(List<MusicBean> musicBeen) {
        MusicBean.loader = new ImageLoader(((App) getActivity().getApplication()).getRequestQueue(), new BitmapCache(getActivity()));
        RvAdapter<MusicBean> adapter = new RvAdapter<>(getActivity(), musicBeen, R.layout.right_fg_rv_item, BR.music);
        rv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rv.setAdapter(adapter);
    }

    @Override
    public void showErrorMsg(String errorMsg) {
    }

    public void updateRv(int id) {
        rightPresenter.start(id);
    }
}
