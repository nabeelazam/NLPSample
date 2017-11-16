package com.nlpsample.api;

import android.app.Activity;

import com.nlplibrary.NLPNetworkUtility;
import com.nlplibrary.ServiceCallBack;
import com.nlpsample.models.NLPMatchModel;

public class NLPApiController extends NLPNetworkUtility {

    /**
     * @param act
     */
    public NLPApiController(Activity act) {
        super(act);
    }

    /**
     *
     * @param showProgress
     * @param obj
     */
    public void getNLPMatchList(boolean showProgress, ServiceCallBack obj) {
        this.get(APIUrls.getTopPlayerStatsUrl(), obj, NLPMatchModel.getInstance(), showProgress);
    }

}
