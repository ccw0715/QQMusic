package com.ccw.qqmusic.showMusic.model;

import com.ccw.qqmusic.showMusic.model.bean.MusicBean;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/17 0017.
 */

public interface IMineData {

    void getPlayList(OnDataLoadListener onDataLoadListener);

    List<MusicBean> getLocalMusic();
}