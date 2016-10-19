package com.ccw.qqmusic.showMusic.view.fragment;

import com.ccw.qqmusic.showMusic.model.bean.MusicBean;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/19 0019.
 */

public interface IRightView {
    void inRv(List<MusicBean> musicBeen);

    void showErrorMsg(String errorMsg);
}
