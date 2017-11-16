package com.nlpsample.api;

import android.app.Activity;

import com.nlplibrary.NFLNetworkUtility;
import com.nlplibrary.ServiceCallBack;
import com.nlpsample.models.NFLMatchModel;

public class NLPApiController extends NFLNetworkUtility {

    /**
     * @param act
     */
    public NLPApiController(Activity act) {
        super(act);
    }

    /**
     * Function to call API call for getting match list.
     *
     * @param showProgress
     * @param obj
     */
    public void getNLPMatchList(boolean showProgress, ServiceCallBack obj) {
        this.get(APIUrls.getTopPlayerStatsUrl(), obj, NFLMatchModel.getInstance(), showProgress);
    }

}
