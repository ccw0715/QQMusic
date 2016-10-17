package com.ccw.qqmusic.showMusic.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccw.qqmusic.BaseFragment;
import com.ccw.qqmusic.R;
import com.ccw.qqmusic.showMusic.model.bean.MusicBean;
import com.ccw.qqmusic.showMusic.model.bean.UserBean;
import com.ccw.qqmusic.showMusic.view.view.MyListView;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/17 0017.
 */

public class MineFragment extends BaseFragment implements IMineView{

    private View view;
    private MyListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mine_fg_layout, container, false);
        initView();
        return view;
    }

    private void initView() {
        lv = ((MyListView) view.findViewById(R.id.play_list_lv));
    }
    @Override
    public void setUserInfo(UserBean userBean) {

    }

    @Override
    public void setPlayList(List<MusicBean> list) {
//        lv.setAdapter();
    }
}
