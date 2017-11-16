package com.nlplibrary.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.nlplibrary.VolleySingletonInstance;
import com.nlplibrary.utils.CustomThread;
import com.nlplibrary.utils.Logger;

public class ServiceUtil {

    private static ServiceUtil _instance;// = new ServiceUtil();
    private static Context mContext;
    private ServiceUtil() {
    }

    private final String TAG = ServiceUtil.class.getName();

    public static ServiceUtil getInstance(Context context) {
        mContext = context;
        _instance = new ServiceUtil();
        return _instance;
    }

    /**
     * @param url
     * @param tag
     * @param listener
     */
    public void callServiceAsString(String url, final String tag, final ServiceResponseAsStringListener listener) {

        final StringRequest volleyStringReq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                //Logger.log(TAG + response);
                if (listener != null) {
                    listener.setSuccessResult(response);
                }
                VolleySingletonInstance.getInstance(mContext).cancelPendingRequests(tag);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Logger.log(TAG + "Error: " + error.getMessage());
                VolleySingletonInstance.getInstance(mContext).cancelPendingRequests(tag);
                if (listener != null) {
                    listener.setErrorResult(error.getMessage());
                }
            }
        });

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //for volley calling
                // Adding request to request queue
                VolleySingletonInstance.getInstance(mContext).addToRequestQueue(volleyStringReq);
            }
        };
        CustomThread.getInstance().startThreadCall(runnable);
    }
}
