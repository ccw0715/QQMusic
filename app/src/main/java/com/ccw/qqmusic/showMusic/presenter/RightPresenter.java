package com.ccw.qqmusic.showMusic.presenter;

import android.os.Handler;

import com.ccw.qqmusic.IBasePresenter;
import com.ccw.qqmusic.showMusic.model.IRightData;
import com.ccw.qqmusic.showMusic.model.IRightDataImp;
import com.ccw.qqmusic.showMusic.model.OnDataLoadListener;
import com.ccw.qqmusic.showMusic.model.bean.MusicBean;
import com.ccw.qqmusic.showMusic.view.fragment.IRightView;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/19 0019.
 */

public class RightPresenter implements IBasePresenter{
    private IRightView iRightView;
    private IRightData iRightData;
    private Handler mHandler=new Handler();

    public RightPresenter(IRightView iRightView) {
        this.iRightView = iRightView;
        iRightData = new IRightDataImp();
    }

    public void start(int id){
        iRightData.getPlayList(id, new OnDataLoadListener() {
            @Override
            public void onLoadSuccess(final List<MusicBean> list) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iRightView.inRv(list);
                    }
                });
            }

            @Override
            public void onLoadFailed(final String errorMsg) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iRightView.showErrorMsg(errorMsg);
                    }
                });
            }
        });
    }
    @Override
    public void start() {

    }
}
