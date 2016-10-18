package com.ccw.qqmusic.showMusic.model;

import android.content.Context;

import com.ccw.qqmusic.showMusic.model.bean.MusicBean;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public interface IShowData {
    void saveData(MusicBean musicBean, Context context);

    MusicBean loadData(Context context);
}