package com.picklemixel.mister.colourlovers.application;

import android.app.Application;
import android.content.Context;

public class ColourLoversApplication extends Application {
    public static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
    }

}
