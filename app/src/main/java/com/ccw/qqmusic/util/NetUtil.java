package com.ccw.qqmusic.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by 蔡灿武 on 2016/10/19 0019.
 */

public class NetUtil {
    public static String HTTPURL = "http://route.showapi.com/213-4?showapi_appid=25798&showapi_sign=6d9b08da66aa47adb911f1065b7baa4e&topid=%d&";
    public static String LRCURL="http://route.showapi.com/213-2?showapi_appid=25798&showapi_sign=6d9b08da66aa47adb911f1065b7baa4e&musicid=%d&";
    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .build();
    public static OkHttpClient getClient(){
        return client;
    }
}