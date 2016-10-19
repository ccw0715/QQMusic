package com.ccw.qqmusic.showMusic.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccw.qqmusic.BaseFragment;
import com.ccw.qqmusic.R;
import com.ccw.qqmusic.localMusic.view.LocalMusicActivity;
import com.ccw.qqmusic.showMusic.model.bean.MusicBean;
import com.ccw.qqmusic.showMusic.model.bean.UserBean;
import com.ccw.qqmusic.showMusic.presenter.MinePresenter;
import com.ccw.qqmusic.showMusic.view.IShowView;
import com.ccw.qqmusic.showMusic.view.adapter.MineFgLvAdapter;
import com.ccw.qqmusic.showMusic.view.view.MyListView;
import com.ccw.qqmusic.util.PlayUtil;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/17 0017.
 */

public class MineFragment extends BaseFragment implements IMineView {
    private MinePresenter minePresenter = new MinePresenter(this);
    private View view;
    private MyListView lv;
    private TextView tv;
    private Handler mHandler = new Handler();
    private IShowView iShowView;
    private LinearLayout localMusic;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IShowView) {
            iShowView = (IShowView) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mine_fg_layout, container, false);
        initView();
        minePresenter.start();
        return view;
    }

    private void initView() {
        lv = ((MyListView) view.findViewById(R.id.play_list_lv));
        tv = ((TextView) view.findViewById(R.id.play_list_size_tv));
        localMusic = ((LinearLayout) view.findViewById(R.id.local_music));
        localMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LocalMusicActivity.class));
            }
        });
    }

    @Override
    public void setUserInfo(UserBean userBean) {

    }

    @Override
    public void setPlayList(final List<MusicBean> list) {
        tv.setText(list.size() + "");
        lv.setAdapter(new MineFgLvAdapter(list, getActivity()));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                PlayUtil.startService(getActivity(), list.get(position), PlayUtil.PLAY);
                Log.d("哈哈日记", "onItemClick: sda");
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        iShowView.updateMusic(list.get(position));
                    }
                }, 500);
            }
        });
    }
}