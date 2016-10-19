package com.ccw.qqmusic.showMusic.model;

import com.ccw.qqmusic.util.JsonParse;
import com.ccw.qqmusic.util.NetUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 蔡灿武 on 2016/10/19 0019.
 */

public class IRightDataImp implements IRightData {
    @Override
    public void getPlayList(int id, final OnDataLoadListener onDataLoadListener) {
        final Request request = new Request.Builder().url(String.format(NetUtil.HTTPURL, id)).build();
        NetUtil.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onDataLoadListener.onLoadFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    onDataLoadListener.onLoadSuccess(JsonParse.parseJsonList(response.body().string()));
                }
            }
        });
    }
}