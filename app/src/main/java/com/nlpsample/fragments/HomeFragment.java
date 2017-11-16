package com.nlpsample.fragments;

import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.diegocarloslima.fgelv.lib.FloatingGroupExpandableListView;
import com.diegocarloslima.fgelv.lib.WrapperExpandableListAdapter;
import com.nlplibrary.ServiceCallBack;
import com.nlplibrary.utils.Logger;
import com.nlpsample.R;
import com.nlpsample.adapters.NRLStatsAdapter;
import com.nlpsample.api.NFLApiController;
import com.nlpsample.models.NFLMatch;
import com.nlpsample.models.NFLMatchModel;
import com.nlpsample.models.PlayerDetailModel;
import com.nlpsample.models.StatSection;
import com.nlpsample.utils.LayoutUtil;
import com.nlpsample.utils.TextUtils;
import com.nlpsample.utils.refreshUtil.OnRefreshListener;
import com.nlpsample.utils.refreshUtil.RefreshLayoutUtil;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private final String NO_DATA_FOUND = "No data found.";
    private NFLApiController mApiService;
    private FloatingGroupExpandableListView mStatsListView;
    private WrapperExpandableListAdapter mWrapperAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;


    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = new NFLApiController(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mStatsListView = LayoutUtil.getExpendableListViewWithEmptyView(getActivity());
        mStatsListView.setGroupIndicator(null);
        mStatsListView.setSelector(new StateListDrawable());
        mStatsListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // Disabling header click
                return true;
            }
        });

        // Getting Match List
        getNFLMatchList(true);

        mSwipeRefreshLayout = RefreshLayoutUtil.getSwipeRefreshLayout(getActivity(), R.id.stats_swipe_view);
        RefreshLayoutUtil.setOnRefreshListener(getActivity(), mSwipeRefreshLayout, new OnRefreshListener() {
            @Override
            public void onRefresh() {
                getNFLMatchList(false);
            }
        });
        RefreshLayoutUtil.setRefreshScrollListener(mStatsListView, mSwipeRefreshLayout);

        //mApiService.getPlayerDetails("55011", "108392", true, new ServiceCallBack(HomeFragment.this, "getPlayerDetailsCallBack"));

    }


    /**
     * Get NFL Match list cal
     */
    private void getNFLMatchList(boolean showProgress) {
        mApiService.getNLPMatchList(showProgress, new ServiceCallBack(HomeFragment.this, "getMatchListCallBack"));
    }

    /**
     * Call Back method for getting match list function
     *
     * @param caller
     * @param model
     */
    public void getMatchListCallBack(Object caller, Object model) {

        NFLMatchModel.getInstance().setList(model);

        if (NFLMatchModel.getInstance().isValidData()) {
            Logger.log("Match List === " + NFLMatchModel.getInstance().response.size());
            setMatchStatsAdapter();
            LayoutUtil.setListViewEmptyViewText(getActivity(), "");
        } else {
            LayoutUtil.setListViewEmptyViewText(getActivity(), NO_DATA_FOUND);
        }

        RefreshLayoutUtil.onRefreshFinish(mSwipeRefreshLayout);
    }


    public void getPlayerDetailsCallBack(Object caller, Object model) {
        PlayerDetailModel.getInstance().setList(model);

        if (PlayerDetailModel.getInstance() != null &&
                PlayerDetailModel.getInstance().player != null) {
            Logger.log("Player Name === " + PlayerDetailModel.getInstance().player.fullName);

        }
    }


    /**
     * Setting Stats list adapter
     */
    private void setMatchStatsAdapter() {
        //mStatsListView.setAdapter(new NRLStatsAdapter(getContext(), new ArrayList<StatSection>()));
        NRLStatsAdapter mStatsAdapter = new NRLStatsAdapter(getActivity(), getStatSectionWiseData(NFLMatchModel.getInstance().response));
        mWrapperAdapter = new WrapperExpandableListAdapter(mStatsAdapter);
        mStatsListView.setAdapter(mWrapperAdapter);
        for (int i = 0; i < mWrapperAdapter.getGroupCount(); i++) {
            mStatsListView.expandGroup(i);
        }
    }


    /**
     * Formats data Section wise.
     *
     * @param matchList
     * @return
     */
    private ArrayList<StatSection> getStatSectionWiseData(ArrayList<NFLMatch> matchList) {
        ArrayList<StatSection> dataList = new ArrayList<>();
        ArrayList<NFLMatch> childData;
        NFLMatch match = null;
        StatSection section = null;
        for (int index = 0, size = matchList.size(); index < size; index++) {
            section = new StatSection();
            match = matchList.get(index);
            childData = new ArrayList<>();
            section.groupTitle = TextUtils.getValidText(match.statType);
            childData.add(match);
            section.childItemData = childData;
            dataList.add(section);
        }
        return dataList;
    }

}
