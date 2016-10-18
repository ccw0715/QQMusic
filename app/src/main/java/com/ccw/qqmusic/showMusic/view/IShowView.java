package com.ccw.qqmusic.showMusic.view;

import com.ccw.qqmusic.showMusic.model.bean.MusicBean;

/**
 * Created by 蔡灿武 on 2016/10/17 0017.
 */

public interface IShowView {
    void updateMusic(MusicBean bean);

    void updatePauseBtn();
}
