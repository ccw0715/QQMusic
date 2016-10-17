package com.ccw.qqmusic.showMusic.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.ccw.qqmusic.BaseActivity;
import com.ccw.qqmusic.R;
import com.ccw.qqmusic.showMusic.model.bean.MusicBean;
import com.ccw.qqmusic.showMusic.view.adapter.VpAdapter;
import com.ccw.qqmusic.showMusic.view.fragment.FindFragment;
import com.ccw.qqmusic.showMusic.view.fragment.MineFragment;
import com.ccw.qqmusic.showMusic.view.fragment.MusicFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IShowView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        List<Fragment> list=new ArrayList<>();
        list.add(new MineFragment());
        list.add(new MusicFragment());
        list.add(new FindFragment());
        viewPager.setAdapter(new VpAdapter(getSupportFragmentManager(),list));
    }

    @Override
    public void updateMusic(MusicBean bean) {

    }
}
