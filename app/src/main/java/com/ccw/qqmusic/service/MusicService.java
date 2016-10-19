package com.ccw.qqmusic.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.RemoteViews;

import com.ccw.qqmusic.R;
import com.ccw.qqmusic.util.PlayUtil;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public class MusicService extends Service{
    private Notification.Builder builder;
    private RemoteViews remoteViews;
    private static final int STOPSERVICE=3;
    private NotificationManager manager;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        builder = new Notification.Builder(this);
        remoteViews = new RemoteViews(getPackageName(), R.layout.nf_layout);
        Intent intent = new Intent(this,MusicService.class);
        intent.putExtra("type",STOPSERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        remoteViews.setOnClickPendingIntent(R.id.nf_close_btn,pendingIntent);
        builder.setContent(remoteViews).setSmallIcon(R.drawable.default1);
        startForeground(1,builder.build());
        manager = ((NotificationManager) getSystemService(NOTIFICATION_SERVICE));

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int type = intent.getIntExtra("type", PlayUtil.STOP);
        String musicName = intent.getStringExtra("musicName");
        remoteViews.setTextViewText(R.id.music_name,musicName);
        manager.notify(1,builder.build());
        switch (type){
            case PlayUtil.PLAY:
                PlayUtil.play(this,intent.getStringExtra("musicPath"));
                break;
            case PlayUtil.PAUSE:
                PlayUtil.pause();
                break;
            case PlayUtil.STOP:
                PlayUtil.stop();
                break;
            case STOPSERVICE:
                stopSelf();
                sendBroadcast(new Intent(PlayUtil.STOPSERVICE_ACTION));
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        PlayUtil.stop();
    }
}
