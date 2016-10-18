package com.ccw.qqmusic.localMusic.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.ccw.qqmusic.showMusic.model.bean.MusicBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public class ILocalDataImp implements ILocalData {
    @Override
    public List<MusicBean> getLocalMusic(Context context) {
        List<MusicBean> list = new ArrayList<>();
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            String musicPath = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            String musicName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
            String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            long duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
            list.add(new MusicBean(musicName, musicPath, artist, duration));
        }
        cursor.close();
        return list;
    }
}