package com.ccw.qqmusic.localMusic.model;

import android.content.Context;

import com.ccw.qqmusic.showMusic.model.bean.MusicBean;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public interface ILocalData {
    List<MusicBean> getLocalMusic(Context context);
}