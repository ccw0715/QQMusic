package com.ccw.qqmusic.showMusic.view.fragment;

import com.ccw.qqmusic.showMusic.model.bean.MusicBean;
import com.ccw.qqmusic.showMusic.model.bean.UserBean;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/17 0017.
 */

public interface IMineView {
    void setUserInfo(UserBean userBean);

    void setPlayList(List<MusicBean> list);
}
