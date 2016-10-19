package com.ccw.qqmusic.localMusic.presenter;

import android.content.Context;

import com.ccw.qqmusic.IBasePresenter;
import com.ccw.qqmusic.localMusic.model.ILocalData;
import com.ccw.qqmusic.localMusic.model.ILocalDataImp;
import com.ccw.qqmusic.localMusic.view.fragment.ILocalMusicView;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public class LocalMusicPresenter implements IBasePresenter {
    private ILocalMusicView iLocalMusicView;
    private ILocalData iLocalData;

    public LocalMusicPresenter(ILocalMusicView iLocalMusicView) {
        this.iLocalMusicView = iLocalMusicView;
        iLocalData=new ILocalDataImp();
    }
    public void start(Context context){
        iLocalMusicView.initLv(iLocalData.getLocalMusic(context));
    }

    @Override
    public void start() {

    }
}
