package com.ccw.qqmusic.util;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

import com.ccw.qqmusic.service.MusicService;
import com.ccw.qqmusic.showMusic.model.bean.MusicBean;

import java.io.IOException;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public class PlayUtil {
    public static MediaPlayer player = null;
    public final static int PLAY = 0;
    public final static int PAUSE = 1;
    public final static int STOP = 2;
    //记录当前的播放转态
    public static int CURRENT_STATE = 2;

    public static void play(String musicPath) {
        if (player == null) {
            init();
        }
        player.reset();
        try {
            player.setDataSource(musicPath);
            player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pause() {
        if (player != null && player.isPlaying()) {
            player.pause();
            CURRENT_STATE = PAUSE;
        } else if (player != null && !player.isPlaying()) {
            player.start();
            CURRENT_STATE = PLAY;
        }
    }

    public static void stop() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
            CURRENT_STATE = STOP;
        }
    }

    private static void init() {
        player = new MediaPlayer();
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                CURRENT_STATE = PLAY;
            }
        });
    }

    public static void startService(Context context, MusicBean musicBean, int type) {
        Intent intent = new Intent(context, MusicService.class);
        intent.putExtra("type", type);
        intent.putExtra("musicPath", musicBean.getMusicPath());
        intent.putExtra("musicName", musicBean.getMusicName());
        context.startService(intent);
    }
}