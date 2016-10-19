package com.ccw.qqmusic.showMusic.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccw.qqmusic.BaseFragment;
import com.ccw.qqmusic.R;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public class RankFragment extends BaseFragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.rank_fg_layout, container, false);
        }
        FragmentManager manager = getChildFragmentManager();
        LeftFragment leftFg = (LeftFragment) manager.findFragmentById(R.id.left_fg);
        RightFragment rightFg = (RightFragment) manager.findFragmentById(R.id.right_fg);
        leftFg.setRightFragment(rightFg);
        return view;
    }
}