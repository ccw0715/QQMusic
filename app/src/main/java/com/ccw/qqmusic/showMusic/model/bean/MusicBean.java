package com.ccw.qqmusic.showMusic.model.bean;

/**
 * Created by 蔡灿武 on 2016/10/17 0017.
 */

public class MusicBean {

    private String musicName;
    private String musicPath;
    private String author;
    private long time;

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

}
