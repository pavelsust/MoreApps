package com.example.moreapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by android on 4/16/2017.
 */

public class App{

    public RequestQueue requestQueue;
    private static App mInstance;
    public static Context context;


    public App(Context context){

        this.context = context;
        mInstance = this;
        getInstance();
    }


    public static synchronized App getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag("");
        getRequestQueue().add(req);
    }
}
