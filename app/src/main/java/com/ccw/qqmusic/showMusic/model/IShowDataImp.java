package com.ccw.qqmusic.showMusic.model;

import android.os.Environment;

import com.ccw.qqmusic.showMusic.model.bean.MusicBean;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/17 0017.
 */

public class IShowDataImp implements IShowDate {


    @Override
    public List<MusicBean> getPlayList() {
        List<MusicBean> list = getLocalMusic();
        if (list.size() > 3) {
            list = list.subList(0, 3);
        }
        return list;
    }

    @Override
    public List<MusicBean> getLocalMusic() {
        List<MusicBean> list = new ArrayList<>();
        File rootFile = Environment.getExternalStorageDirectory();
        getMp3(list, rootFile);
        return list;
    }

    private void getMp3(final List<MusicBean> list, File rootFile) {
        rootFile.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isFile()) {
                    if (pathname.getName().endsWith(".mp3")) {
                        String name = pathname.getName();
                        String path = pathname.getAbsolutePath();
                        MusicBean bean = new MusicBean();
                        bean.setMusicName(name);
                        bean.setMusicPath(path);
                        list.add(bean);
                    }
                } else {
                    getMp3(list, pathname);
                }

                return false;
            }
        });
    }
}