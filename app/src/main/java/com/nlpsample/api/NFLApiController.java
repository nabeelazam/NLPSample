package com.nlpsample.api;

import android.app.Activity;
import android.widget.ImageView;

import com.nlplibrary.NFLNetworkUtility;
import com.nlplibrary.ServiceCallBack;
import com.nlplibrary.utils.Logger;
import com.nlpsample.models.NFLMatchModel;
import com.nlpsample.models.PlayerDetailModel;

public class NFLApiController extends NFLNetworkUtility {

    /**
     * @param act
     */
    public NFLApiController(Activity act) {
        super(act);
    }

    /**
     * Function to call API function for getting match list.
     *
     * @param showProgress
     * @param obj
     */
    public void getNLPMatchList(boolean showProgress, ServiceCallBack obj) {
        this.get(APIUrls.getTopPlayerStatsUrl(), obj, NFLMatchModel.getInstance(), showProgress);
    }


    /**
     * Calling API function to get players details based on given player id and team id
     * @param teamId
     * @param playerId
     * @param showProgress
     * @param obj
     */
    public void getPlayerDetails(String teamId, String playerId, boolean showProgress, ServiceCallBack obj) {
        String url = String.format(APIUrls.getPlayerDetails(), teamId, playerId);
        Logger.log("getPlayerDetails Url: " + url);
        this.get(url, obj, PlayerDetailModel.getInstance(), showProgress);
    }

    /**
     *
     * @param activity
     * @param playerId
     * @param imageView
     * @param defaultImageId
     */
    public void downloadPlayerImage(Activity activity, String playerId, final ImageView imageView, final int defaultImageId) {
        String url = String.format(APIUrls.getPlayerImageUrl(), playerId);
        this.downloadImageWithVolley(activity,url, imageView, defaultImageId);
    }

}
