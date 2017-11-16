package com.nlpsample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.androidquery.AQuery;
import com.nlplibrary.ServiceCallBack;
import com.nlpsample.R;
import com.nlpsample.adapters.PlayerGridAdapter;
import com.nlpsample.api.NFLApiController;
import com.nlpsample.models.Player;
import com.nlpsample.models.PlayerDetailModel;
import com.nlpsample.models.TopPlayer;
import com.nlpsample.utils.Constants;
import com.nlpsample.utils.DataUtils;
import com.nlpsample.utils.TextUtils;

public class PlayerDetailFragment extends Fragment {

    private static final String BUNDLE_PLAYER = "BUNDLE_SELECTED_PLAYER";
    private static final String BUNDLE_TEAM_ID = "BUNDLE_TEAM_ID";
    private final String NO_DATA_FOUND = "No data found.";
    private NFLApiController mApiService;
    private TopPlayer mSelectedPlayer;
    private String mTeamId = "";
    private AQuery mAQuery;

    private GridView mPlayerGridView;
    private PlayerGridAdapter mPlayerGridAdapter;

    public PlayerDetailFragment() {
    }

    public static PlayerDetailFragment newInstance(TopPlayer player, String teamId) {
        PlayerDetailFragment fragment = new PlayerDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_PLAYER, player);
        bundle.putString(BUNDLE_TEAM_ID, teamId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = new NFLApiController(getActivity());

        if (getArguments() != null) {
            mSelectedPlayer = (TopPlayer) getArguments().getSerializable(BUNDLE_PLAYER);
            mTeamId = getArguments().getString(BUNDLE_TEAM_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_player_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAQuery = new AQuery(getActivity(), view);
        mPlayerGridView = (GridView) view.findViewById(R.id.player_grid_view);

        // Getting Player details
        getPlayerDetails(true);
    }


    /**
     * Get NFL Match list cal
     */
    private void getPlayerDetails(boolean showProgress) {
        mApiService.getPlayerDetails(TextUtils.getValidText(mTeamId), TextUtils.getValidText(mSelectedPlayer.id), showProgress, new ServiceCallBack(PlayerDetailFragment.this, "getPlayerDetailsCallBack"));
    }

    /**
     * Callback method for player detail call
     *
     * @param caller
     * @param model
     */
    public void getPlayerDetailsCallBack(Object caller, Object model) {
        PlayerDetailModel.getInstance().setList(model);
        if (PlayerDetailModel.getInstance().isValidData()) {
            //Logger.log("Player Name === " + PlayerDetailModel.getInstance().player.fullName);
            setHomeGridAdapter(PlayerDetailModel.getInstance().player);
            mAQuery.id(R.id.tv_no_stats_found).gone();
        } else {
            mAQuery.id(R.id.tv_no_stats_found).visible();
        }
    }

    /**
     * Populate player demographic information
     *
     * @param player
     */
    private void populatePlayerDemographics(final Player player) {
        mAQuery.id(R.id.tv_player_name).text(TextUtils.getValidText(player.fullName));
        mAQuery.id(R.id.tv_player_position).text(TextUtils.getValidText(player.position));
        String dob = TextUtils.getFormattedDate(Constants.SERVER_DATE_FORMAT, Constants.DISPLAY_DATE_FORMAT, player.dateOfBirth);
        mAQuery.id(R.id.tv_player_dob).text(TextUtils.getValidText(dob));
        // Fetching image
        mApiService.downloadPlayerImage(getActivity(), mSelectedPlayer.id, mAQuery.id(R.id.player_image).getImageView(), R.drawable.ic_player);
    }


    /**
     * Setting grid adapter
     *
     * @param player
     */
    private void setHomeGridAdapter(final Player player) {

        populatePlayerDemographics(player);

        mPlayerGridAdapter = null;
        mPlayerGridAdapter = new PlayerGridAdapter(getActivity(), DataUtils.getLastMatchStats(player));
        mPlayerGridView.setAdapter(mPlayerGridAdapter);
    }


}
