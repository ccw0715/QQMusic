package com.ccw.qqmusic.playMusic.presenter;

import com.ccw.qqmusic.IBasePresenter;
import com.ccw.qqmusic.playMusic.view.IPlayerView;

/**
 * Created by 蔡灿武 on 2016/10/20 0020.
 */

public class PlayerPresenter implements IBasePresenter {
    private IPlayerView iPlayerView;

    public PlayerPresenter(IPlayerView iPlayerView) {
        this.iPlayerView = iPlayerView;
    }

    @Override
    public void start() {
        iPlayerView.updatePlayerControl();
    }
}
