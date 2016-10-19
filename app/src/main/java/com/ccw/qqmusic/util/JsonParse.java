package com.ccw.qqmusic.util;

import com.ccw.qqmusic.showMusic.model.bean.MusicBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蔡灿武 on 2016/10/19 0019.
 */

public class JsonParse {
    public static List<MusicBean> parseJsonList(String json) {
        List<MusicBean> list = new ArrayList<>();
        try {
            JSONArray songList = new JSONObject(json).getJSONObject("showapi_res_body").getJSONObject("pagebean").getJSONArray("songlist");
            for (int i = 0; i < songList.length(); i++) {
                JSONObject data = songList.getJSONObject(i);
                String songName = data.getString("songname");
                int seconds = data.getInt("seconds");
                String albummid = data.getString("albummid");
                String albumpic_big = data.getString("albumpic_big");
                String albumpic_small = data.getString("albumpic_small");
                String downUrl = data.getString("downUrl");
                String url = data.getString("url");
                String singername = data.getString("singername");
                int songid = data.getInt("songid");
                int singerid = data.getInt("singerid");
                int albumid = data.getInt("albumid");
                list.add(new MusicBean(songName,url,singername,seconds,albummid,songid,albumpic_big,singerid,albumpic_small,downUrl,albumid));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
