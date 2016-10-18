package com.ccw.qqmusic.showMusic.presenter;

import android.os.Handler;
import android.util.Log;

import com.ccw.qqmusic.IBasePresenter;
import com.ccw.qqmusic.showMusic.model.IMineDataImp;
import com.ccw.qqmusic.showMusic.model.IMineData;
import com.ccw.qqmusic.showMusic.model.OnDataLoadListener;
import com.ccw.qqmusic.showMusic.model.bean.MusicBean;
import com.ccw.qqmusic.showMusic.view.fragment.IMineView;

import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */
public class MinePresenter implements IBasePresenter {
    private IMineData iMineDate;
    private IMineView iMineView;
    private Handler mHandler = new Handler();

    public MinePresenter(IMineView iMineView) {
        this.iMineView = iMineView;
        iMineDate = new IMineDataImp();
    }

    @Override
    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                iMineDate.getPlayList(new OnDataLoadListener() {
                    @Override
                    public void onLoadSuccess(final List<MusicBean> list) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                iMineView.setPlayList(list);
                            }
                        });
                    }
                    @Override
                    public void onLoadFailed(String errorMsg) {
                        Log.d("哈哈日记", "onLoadFailed: dfafa");
                    }
                });
            }
        }).start();
    }
}