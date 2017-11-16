package com.nlpsample.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.diegocarloslima.fgelv.lib.FloatingGroupExpandableListView;
import com.nlplibrary.utils.Logger;
import com.nlpsample.R;
import com.nlpsample.activities.MainActivity;
import com.nlpsample.api.NFLApiController;
import com.nlpsample.fragments.PlayerDetailFragment;
import com.nlpsample.models.TopPlayer;

import java.util.ArrayList;

public class LayoutUtil {

    private static final String NAME = "Name: ", JUMPER_NUMBER = "Jumper No: ", POSITION = "Position: ", STATS_VALUE="Stats Value: ";

    /**
     * Getting layout inflator
     *
     * @param context
     * @return
     */
    public static LayoutInflater getLayoutInflater(Context context) {
        if (context != null) {
            return (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        return null;
    }


    /**
     * @param context
     * @return
     */
    public static FloatingGroupExpandableListView getExpendableListViewWithEmptyView(Activity context) {
        FloatingGroupExpandableListView customLV = (FloatingGroupExpandableListView) context.findViewById(R.id.customExpendableListView);
        if (customLV != null) {
            customLV.setFooterDividersEnabled(false);
        }
        return customLV;
    }


    /**
     * @param context
     * @param emptyText
     */
    public static void setListViewEmptyViewText(Activity context, String emptyText) {
        if (context != null) {
            TextView emptyTv = (TextView) context.findViewById(android.R.id.empty);
            if (emptyTv != null) {
                emptyTv.setText(emptyText);
            }
        }
    }




    /**
     * @param activity
     * @param topPlayers
     * @param parentLayout
     */
    public static void inflateTopPlayers(Activity activity, ArrayList<TopPlayer> topPlayers, String teamId, LinearLayout parentLayout) {
        LayoutInflater mInflater = getLayoutInflater(activity);

        parentLayout.removeAllViews();

        for (TopPlayer player : topPlayers) {
            View playerView = mInflater.inflate(R.layout.layout_player_item, null);
            parentLayout.addView(playerView);
            populatePlayerData(activity, playerView, player, teamId);
        }
    }

    /**
     * @param activity
     * @param parentView
     * @param player
     */
    private static void populatePlayerData(final Activity activity, View parentView, final TopPlayer player, final String teamId) {

        ImageView imgPlayer = (ImageView) parentView.findViewById(R.id.img_top_player);
        TextView tvPlayerName = parentView.findViewById(R.id.tv_player_name);
        TextView tvJumperNo = parentView.findViewById(R.id.tv_jumper_number);
        TextView tvPosition = parentView.findViewById(R.id.tv_player_position);
        TextView tvPlayerStat = parentView.findViewById(R.id.tv_stat_value);

        tvPlayerName.setText(TextUtils.getValidText(player.fullName));
        tvJumperNo.setText(TextUtils.getDifferentFontText(JUMPER_NUMBER, player.jumperNumber+""));
        tvPosition.setText(TextUtils.getDifferentFontText(POSITION, player.position));
        tvPlayerStat.setText(TextUtils.getDifferentFontText(STATS_VALUE, player.statValue+""));

        // Fetching image
        new NFLApiController(activity).downloadPlayerImage(activity, player.id, imgPlayer,R.drawable.ic_player );

        parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logger.log(player.fullName);
                MainActivity.replaceFragmentByTag((FragmentActivity) activity, PlayerDetailFragment.newInstance(player, teamId));
            }
        });
    }

}
