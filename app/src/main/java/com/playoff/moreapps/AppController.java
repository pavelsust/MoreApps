package com.playoff.moreapps;

import android.app.Application;

import com.example.moreapp.App;

/**
 * Created by android on 4/17/2017.
 */

public class AppController extends Application {

    App app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = new App(getApplicationContext());
    }
}
