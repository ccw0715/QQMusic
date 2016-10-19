package com.ccw.qqmusic;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by 蔡灿武 on 2016/10/19 0019.
 */

public class App extends Application {
    private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(this);
    }
    public RequestQueue getRequestQueue(){
        return requestQueue;
    }
}