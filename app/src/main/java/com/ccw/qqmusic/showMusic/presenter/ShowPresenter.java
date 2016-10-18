package com.ccw.qqmusic.showMusic.presenter;

import android.content.Context;

import com.ccw.qqmusic.IBasePresenter;
import com.ccw.qqmusic.showMusic.model.IShowData;
import com.ccw.qqmusic.showMusic.model.IShowDataImp;
import com.ccw.qqmusic.showMusic.model.bean.MusicBean;
import com.ccw.qqmusic.showMusic.view.IShowView;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public class ShowPresenter implements IBasePresenter{
    private IShowData iShowData;
    private IShowView iShowView;

    public ShowPresenter(IShowView iShowView) {
        this.iShowView = iShowView;
        iShowData = new IShowDataImp();
    }

    public void saveData(MusicBean musicBean){
        iShowData.saveData(musicBean, (Context) iShowView);
    }
    public void loadData(){
        iShowView.updateMusic(iShowData.loadData((Context) iShowView));
    }
    @Override
    public void start() {

    }
}