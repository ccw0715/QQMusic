package com.ccw.qqmusic.localMusic.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ccw.qqmusic.R;
import com.ccw.qqmusic.localMusic.view.adapter.LocalVpAdapter;
import com.ccw.qqmusic.localMusic.view.fragment.LocalArtistFragment;
import com.ccw.qqmusic.localMusic.view.fragment.LocalMusicFragment;

import java.util.ArrayList;
import java.util.List;

public class LocalMusicActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_music);
        initView();
    }

    private void initView() {
        vp = ((ViewPager) findViewById(R.id.viewPager));
        tabLayout = ((TabLayout) findViewById(R.id.tab_layout));
        List<Fragment> list=new ArrayList<>();
        list.add(new LocalMusicFragment());
        list.add(new LocalArtistFragment());
        String[] titles=new String[]{"歌曲","歌手"};
        vp.setAdapter(new LocalVpAdapter(getSupportFragmentManager(),list,titles));
        tabLayout.setupWithViewPager(vp);
    }
}