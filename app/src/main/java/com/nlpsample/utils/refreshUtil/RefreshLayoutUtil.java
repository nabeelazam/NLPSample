package com.nlpsample.utils.refreshUtil;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListView;

import com.nlplibrary.utils.Logger;
import com.nlpsample.R;

public class RefreshLayoutUtil {

    /**
     * @param activity
     * @return
     */
    public static SwipeRefreshLayout getSwipeRefreshLayout(Activity activity, int resourceId) {
        return (SwipeRefreshLayout) activity.findViewById(resourceId);
    }

    /**
     * @param listener
     */
    public static void setOnRefreshListener(final Activity activity, final SwipeRefreshLayout layout, final OnRefreshListener listener) {
        layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Logger.log("mTopSwipeRefreshLayout onRefresh");
                // perform refresh call
//                if (activity != null) {
//                    LayoutUtil.setListViewEmptyViewText(activity, "");
//                }
                layout.setRefreshing(true);
                listener.onRefresh();
            }
        });
        // sets the colors used in the refresh animation
        layout.setColorSchemeResources(
                R.color.colorPrimaryDark,
                R.color.colorPrimary);
    }

    /**
     * @param listView
     * @param refreshLayout
     */
    public static void setRefreshScrollListener(final ListView listView, final SwipeRefreshLayout refreshLayout) {

        if (listView == null || refreshLayout == null) {
            return;
        }
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
               /* if (listView == null || refreshLayout == null) {
                    return;
                }*/
                int topRowVerticalPosition = (/*listView == null ||*/ listView.getChildCount() == 0) ? 0 : listView.getChildAt(0).getTop();
                refreshLayout.setEnabled((topRowVerticalPosition >= 0));
            }
        });
    }


    /**
     * @param recyclerView
     * @param refreshLayout
     */
    public static void setRefreshScrollListener(final RecyclerView recyclerView, final SwipeRefreshLayout refreshLayout) {

        if (recyclerView == null || refreshLayout == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                int topRowVerticalPosition = (recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                refreshLayout.setEnabled((topRowVerticalPosition >= 0));
            }
        });
    }

    /**
     * @param swipeRefreshLayout
     */
    public static void onRefreshFinish(SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setRefreshing(false);
    }
    /**
     *
     * @param gridView
     * @param refreshLayout
     */
    public static void setRefreshScrollListener(final GridView gridView, final SwipeRefreshLayout refreshLayout) {
        if (gridView == null || refreshLayout == null) {
            return;
        }
        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                int topRowVerticalPosition = (gridView.getChildCount() == 0) ? 0 : gridView.getChildAt(0).getTop();
                refreshLayout.setEnabled((topRowVerticalPosition >= 0));
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
    }


}
