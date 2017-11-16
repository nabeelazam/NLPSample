package com.nlplibrary.utils;

import android.os.Handler;
import android.os.HandlerThread;

public class NonUiWorkerThread extends HandlerThread {

    private Handler mWorkerHandler;

    public NonUiWorkerThread(String name) {
        super(name);
    }

    public void postTask(Runnable task){
        mWorkerHandler.post(task);

    }

    public void prepareHandler(){
        mWorkerHandler = new Handler(getLooper());
    }
}
