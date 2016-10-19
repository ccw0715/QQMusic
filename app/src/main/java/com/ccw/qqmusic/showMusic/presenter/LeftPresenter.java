package com.ccw.qqmusic.showMusic.presenter;

import com.ccw.qqmusic.IBasePresenter;
import com.ccw.qqmusic.showMusic.model.ILeftData;
import com.ccw.qqmusic.showMusic.model.ILeftDataImp;
import com.ccw.qqmusic.showMusic.view.fragment.ILeftView;

/**
 * Created by 蔡灿武 on 2016/10/19 0019.
 */

public class LeftPresenter implements IBasePresenter {
    private ILeftData iLeftData;
    private ILeftView iLeftView;

    public LeftPresenter(ILeftView iLeftView) {
        this.iLeftView = iLeftView;
        iLeftData = new ILeftDataImp();
    }

    @Override
    public void start() {
        iLeftView.initContainer(iLeftData.getCategory());
    }
}
