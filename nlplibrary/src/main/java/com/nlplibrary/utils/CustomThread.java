package com.nlplibrary.utils;

/**
 * class that handles all the non ui separated thread network calls, db operations and even data manipulations.
 */
public class CustomThread {

    private static CustomThread _instance;
    private CustomThread(){

    }
    public static CustomThread getInstance(){
        if (_instance == null){
            _instance = new CustomThread();
        }
        return _instance;
    }

    /**
     *
     * @param runnable
     */
    public void startThreadCall(final Runnable runnable){
        try{
            Thread thread = new Thread(runnable);
            thread.start();
        }catch (Exception e){
            Logger.logException(e);
        }
    }
    public void delay(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Logger.logException(e);
        }
    }
    public void delayTwo(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Logger.logException(e);
        }
    }
}
