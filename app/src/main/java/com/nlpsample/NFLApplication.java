package com.nlpsample;

import android.app.Application;

public class NFLApplication extends Application {

    private static NFLApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public static synchronized NFLApplication getInstance() {
        return mInstance;
    }
}
