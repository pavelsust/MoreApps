package com.example.moreapp;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by android on 4/16/2017.
 */

public class App{

    public RequestQueue requestQueue;
    private static App Instance;
    public static Context context;


    public static Context getContext(){
        return App.context;
    }

    public static synchronized App getInstance() {
        return Instance;
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? "" : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag("");
        getRequestQueue().add(req);
    }
}
