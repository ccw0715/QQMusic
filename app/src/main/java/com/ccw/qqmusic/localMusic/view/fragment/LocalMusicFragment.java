package com.ccw.qqmusic.localMusic.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ccw.qqmusic.BaseFragment;
import com.ccw.qqmusic.R;
import com.ccw.qqmusic.localMusic.presenter.LocalMusicPresenter;
import com.ccw.qqmusic.localMusic.view.adapter.LocalMusicLvAdapter;
import com.ccw.qqmusic.showMusic.model.bean.MusicBean;
import com.ccw.qqmusic.util.PlayUtil;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public class LocalMusicFragment extends BaseFragment implements ILocalMusicView{
    private LocalMusicPresenter localMusicPresenter = new LocalMusicPresenter(this);
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.localmusic_fg_layout, container, false);
        initView(view);
        localMusicPresenter.start(getActivity());
        return view;
    }

    private void initView(View view) {
        lv = ((ListView) view.findViewById(R.id.lv));
    }

    @Override
    public void initLv(final List<MusicBean> list) {
        lv.setAdapter(new LocalMusicLvAdapter(list,getActivity()));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PlayUtil.startService(getActivity(),list.get(position),PlayUtil.PLAY);
            }
        });
    }
}
