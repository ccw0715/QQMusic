package com.ccw.qqmusic.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.ccw.qqmusic.util.PlayUtil;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public class MusicService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int type = intent.getIntExtra("type", PlayUtil.STOP);
        switch (type){
            case PlayUtil.PLAY:
                PlayUtil.play(intent.getStringExtra("musicPath"));
                break;
            case PlayUtil.PAUSE:
                PlayUtil.pause();
                break;
            case PlayUtil.STOP:
                PlayUtil.stop();
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}