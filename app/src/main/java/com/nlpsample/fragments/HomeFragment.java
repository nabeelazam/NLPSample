package com.nlpsample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nlplibrary.ServiceCallBack;
import com.nlplibrary.utils.Logger;
import com.nlpsample.R;
import com.nlpsample.api.NLPApiController;
import com.nlpsample.models.NLPMatchModel;

public class HomeFragment extends Fragment {

    private NLPApiController mApiService;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = new NLPApiController(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mApiService.getNLPMatchList(true, new ServiceCallBack(HomeFragment.this, "getMatchListCallBack"));
    }

    public void getMatchListCallBack(Object caller, Object model){
        NLPMatchModel.getInstance().setList((NLPMatchModel) model);

        if(NLPMatchModel.getInstance() != null &&
                NLPMatchModel.getInstance().response != null){
            Logger.log("Match List === " + NLPMatchModel.getInstance().response.size());
        }
    }
}
