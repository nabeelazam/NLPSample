package com.nlpsample;

import android.app.Application;
public class NLPApplication extends Application {
    /**
     * AQuery aq for getting online user
     */
    private static NLPApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public static synchronized NLPApplication getInstance() {
        return mInstance;
    }
}
