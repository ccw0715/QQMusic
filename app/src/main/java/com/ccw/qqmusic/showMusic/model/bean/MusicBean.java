package com.ccw.qqmusic.showMusic.model.bean;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.ccw.qqmusic.R;
import com.ccw.qqmusic.util.PlayUtil;

import java.io.Serializable;

/**
 * Created by 蔡灿武 on 2016/10/17 0017.
 */

public class MusicBean implements Serializable{
    /**
     * songname : 是你
     * seconds : 231
     * albummid : 000JN9VH0F2Lfk
     * songid : 107899426
     * singerid : 34412
     * albumpic_big : http://i.gtimg.cn/music/photo/mid_album_300/f/k/000JN9VH0F2Lfk.jpg
     * albumpic_small : http://i.gtimg.cn/music/photo/mid_album_90/f/k/000JN9VH0F2Lfk.jpg
     * downUrl : http://dl.stream.qqmusic.qq.com/107899426.mp3?vkey=09A63325B0A7D639CDDF4FDE91B8D65D180698AA9762497F49765B52664E1583C08FA1D3CC7D86DDDC3D62A73B46E1DAA55086AC8D948BB3&guid=2718671044
     * url : http://ws.stream.qqmusic.qq.com/107899426.m4a?fromtag=46
     * singername : TFBOYS
     * albumid : 1544479
     */
    private String songName;
    private String url;
    private String singerName;
    private long seconds;
    private String albummid;
    private int songid;
    private int singerid;
    private String albumpic_big;
    private String albumpic_small;
    private String downUrl;
    private int albumid;
    public static ImageLoader loader;

    public void onItemClick(View view) {
        PlayUtil.startService(view.getContext(),this,PlayUtil.PLAY);
    }

    @BindingAdapter("bind:albumpic_small")
    public static void getNetImage(ImageView iv, String url) {
//        Picasso.with(iv.getContext()).load(url).resize(iv.getWidth(),iv.getHeight()).centerCrop().into(iv);
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(iv, R.drawable.default1, R.drawable.default1);
        loader.get(url, listener);
    }

    public MusicBean() {
    }
    public MusicBean(String songName, String url, String singerName, long seconds, String albummid, int songid, String albumpic_big, int singerid, String albumpic_small, String downUrl, int albumid) {
        this.songName = songName;
        this.url = url;
        this.singerName = singerName;
        this.seconds = seconds;
        this.albummid = albummid;
        this.songid = songid;
        this.albumpic_big = albumpic_big;
        this.singerid = singerid;
        this.albumpic_small = albumpic_small;
        this.downUrl = downUrl;
        this.albumid = albumid;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public String getAlbummid() {
        return albummid;
    }

    public void setAlbummid(String albummid) {
        this.albummid = albummid;
    }

    public int getSongid() {
        return songid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }

    public int getSingerid() {
        return singerid;
    }

    public void setSingerid(int singerid) {
        this.singerid = singerid;
    }

    public String getAlbumpic_big() {
        return albumpic_big;
    }

    public void setAlbumpic_big(String albumpic_big) {
        this.albumpic_big = albumpic_big;
    }

    public String getAlbumpic_small() {
        return albumpic_small;
    }

    public void setAlbumpic_small(String albumpic_small) {
        this.albumpic_small = albumpic_small;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    public static ImageLoader getLoader() {
        return loader;
    }

    public static void setLoader(ImageLoader loader) {
        MusicBean.loader = loader;
    }
}
