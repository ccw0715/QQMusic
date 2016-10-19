package com.ccw.qqmusic.showMusic.view.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.ccw.qqmusic.showMusic.view.IShowView;
import com.ccw.qqmusic.util.PlayUtil;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(PlayUtil.STOPSERVICE_ACTION.equals(intent.getAction())){
            ((IShowView) context).updatePauseBtn();
        }else if(PlayUtil.UPDATE_BOTTOM_MUSIC_MSG_ACTION.equals(intent.getAction())){
            ((IShowView) context).updateMusic(PlayUtil.currentMusic);
        }
    }
}