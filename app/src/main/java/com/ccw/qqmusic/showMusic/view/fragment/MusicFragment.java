package com.ccw.qqmusic.showMusic.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccw.qqmusic.BaseFragment;
import com.ccw.qqmusic.R;
import com.ccw.qqmusic.showMusic.view.adapter.MusicFgLvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/17 0017.
 */

public class MusicFragment extends BaseFragment {

    private View view;
    private ViewPager vp;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.music_fg_layout, container, false);
        initView();
        return view;
    }

    private void initView() {
        vp = ((ViewPager) view.findViewById(R.id.viewPager));
        tabLayout = ((TabLayout) view.findViewById(R.id.tabLayout));
        String titles[] = new String[]{"精选", "排行", "歌单", "电台", "MV"};
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new SelectionFragment());
        fragments.add(new RankFragment());
        fragments.add(new PlayListFragment());
        fragments.add(new RadioStationFragment());
        fragments.add(new MVFragment());
        MusicFgLvAdapter adapter = new MusicFgLvAdapter(getChildFragmentManager(), fragments, titles);
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);
    }
}