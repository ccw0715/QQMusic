package com.ccw.qqmusic.showMusic.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.ccw.qqmusic.showMusic.model.bean.MusicBean;
import com.ccw.qqmusic.util.MusicUtil;

/**
 * Created by 蔡灿武 on 2016/10/18 0018.
 */

public class IShowDataImp implements IShowData {
    @Override
    public void saveData(MusicBean musicBean, Context context) {
        SharedPreferences sp = context.getSharedPreferences(MusicUtil.MUSICBEAN, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("musicPath",musicBean.getUrl());
        edit.putString("musicName",musicBean.getSongName());
        edit.commit();
    }

    @Override
    public MusicBean loadData(Context context) {
        MusicBean musicBean = new MusicBean();
        SharedPreferences sp = context.getSharedPreferences(MusicUtil.MUSICBEAN, Context.MODE_PRIVATE);
        musicBean.setUrl(sp.getString("musicPath",""));
        musicBean.setSongName(sp.getString("musicName",""));
        return musicBean;
    }
}
