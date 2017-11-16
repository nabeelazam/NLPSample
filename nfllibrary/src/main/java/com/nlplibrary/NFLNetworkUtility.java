package com.nlplibrary;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nlplibrary.utils.Logger;
import com.nlplibrary.utils.NetworkUtil;
import com.nlplibrary.utils.NonUiWorkerThread;
import com.nlplibrary.utils.ServiceProgressDialog;
import com.nlplibrary.volley.ServiceResponseAsStringListener;
import com.nlplibrary.volley.ServiceUtil;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;

public class NFLNetworkUtility {

    private static final GsonBuilder builder = new GsonBuilder();
    private static Gson gson;
    public static final String SERVER_PROB_MSG = "There is some problem with server, We can't connect you right now, Please try again later.";
    private static final String ENCODE_UTF8 = "utf-8";
    private Activity mContext;

    /**
     * @param act
     */
    public NFLNetworkUtility(Activity act) {
        mContext = act;
        builder.setPrettyPrinting();
        builder.serializeNulls();
        gson = builder.create();
        gson.htmlSafe();
        gson.fieldNamingStrategy();
    }

    /**
     * @param url
     * @param callBack
     * @param model
     * @param showProgress
     */
    public void get(final String url, final ServiceCallBack callBack, final Object model, final boolean showProgress) {

        if (!checkNetWorkAvailable(model, callBack)) {
            return;
        }
        final Handler postDataHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg != null && msg.obj != null) {
                    callBack.invoke(msg.obj);
                    dismissProgressBar(showProgress);
                }
            }
        };
        handleProgressBar(showProgress);
        // Tag used to cancel the request
        final String serviceTag = callBack.caller.getClass().getSimpleName();
        ServiceUtil.getInstance(mContext).callServiceAsString(url, serviceTag, new ServiceResponseAsStringListener() {
            @Override
            public void setSuccessResult(final String response) {
                if (response.isEmpty()) {
                    dismissProgressBar(showProgress);
                    callBack.invoke(model);
                    return;
                }
                Logger.log("Response:: " + response);
                try {
                    if (!validateResponse(response)) { // called on set success result
                        dismissProgressBar(showProgress);
                        callBack.invoke(model);
                        return;
                    }

                    final NonUiWorkerThread nonUiWorkerThread = new NonUiWorkerThread(serviceTag);
                    Runnable dataTask = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Type type = new TypeToken<ArrayList<Object>>(){}.getType();
                                Object dataObj = gson.fromJson(response, type);
                                //Logger.log(dataObj.toString());
                                Message msg = new Message();
                                msg.obj = dataObj;
                                postDataHandler.sendMessage(msg);
                                nonUiWorkerThread.quit();
                            } catch (Exception e) {
                                Message msg = new Message();
                                msg.obj = model;
                                postDataHandler.sendMessage(msg);
                                nonUiWorkerThread.quit();
                                Logger.logException(e);
                                Logger.log("onResponse ::" + serviceTag + "::" + url);
                            }
                        }
                    };
                    nonUiWorkerThread.start();
                    nonUiWorkerThread.prepareHandler();
                    nonUiWorkerThread.postTask(dataTask);

                } catch (Exception e) {
                    Logger.logException(e);
                    dismissProgressBar(showProgress);
                    callBack.invoke(model);
                }
            }

            @Override
            public void setErrorResult(String error) {
                if(error != null){
                    ServiceProgressDialog.showToastMsg(mContext, error);
                    Logger.log("Error: " + serviceTag + "::" + error + "::" + url);
                }
                // hide the progress dialog
                dismissProgressBar(showProgress);
                try {
                    callBack.invoke(model);
                } catch (Exception e) {
                    Logger.logException(e);
                }
            }
        });
    }


    /**
     * @param showProgress
     */
    private void handleProgressBar(boolean showProgress) {
        if (showProgress) {
            ServiceProgressDialog.showDialogNotCancelable(mContext);
        }
    }

    /**
     * @param showProgress
     */
    public void dismissProgressBar(boolean showProgress) {
        if (showProgress) {
            ServiceProgressDialog.dismissDialog();
        }
    }

    /**
     * @param json
     * @return
     */
    private boolean validateResponse(String json) {
            if(json != null && !json.isEmpty()){
                return true;
            }
            ServiceProgressDialog.dismissDialog();
        return false;
    }

    /**
     * @param model
     * @param callBack
     * @return
     */
    private boolean checkNetWorkAvailable(Object model, ServiceCallBack callBack) {
        if (!NetworkUtil.isInternetConnected(mContext)) {
            NetworkUtil.internetFailedDialog(mContext);
            try {
                callBack.invoke(model);
            } catch (Exception e) {
                Logger.logException(e);
            }
            return false;
        }
        return true;
    }

    /**
     * @param keyword
     * @return
     */
    public static String encodeUrlString(String keyword) {
        try {
            keyword = URLEncoder.encode(keyword, ENCODE_UTF8);
        } catch (Exception ignore) {

        }
        return keyword;
    }

}
