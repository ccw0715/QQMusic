package com.ccw.qqmusic.showMusic.model;

import com.ccw.qqmusic.showMusic.model.bean.MusicBean;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public interface OnDataLoadListener {
    void onLoadSuccess(List<MusicBean> list);

    void onLoadFailed(String errorMsg);
}