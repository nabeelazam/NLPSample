package com.nlpsample.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nlpsample.R;
import com.nlpsample.models.NFLMatch;
import com.nlpsample.models.StatSection;
import com.nlpsample.utils.LayoutUtil;
import com.nlpsample.utils.TextUtils;

import java.util.ArrayList;

public class NRLStatsAdapter extends BaseExpandableListAdapter {

    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private ArrayList<StatSection> mStatsData;

    public NRLStatsAdapter(Context context, ArrayList<StatSection> data) {
        mContext = context;
        this.mStatsData = data;
        mLayoutInflater = LayoutUtil.getLayoutInflater(mContext);
    }

    @Override
    public int getGroupCount() {
        return mStatsData.size();
    }

    @Override
    public StatSection getGroup(int groupPosition) {
        return mStatsData.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View rowView = convertView;
        SectionHolder sectionHolder;
        if (rowView == null) {
            sectionHolder = new SectionHolder();
            rowView = mLayoutInflater.inflate(R.layout.layout_section_group_item, parent, false);
            sectionHolder.tvSectionTitle = (TextView) rowView.findViewById(R.id.tv_stat_title);
            rowView.setTag(sectionHolder);
        } else {
            sectionHolder = (SectionHolder) rowView.getTag();
        }

        String groupTitle = getGroup(groupPosition).groupTitle;
        groupTitle = groupTitle.replaceAll("_", " ");
        sectionHolder.tvSectionTitle.setText(TextUtils.capitalizeFirstLetterOfEachWord(groupTitle));

        return rowView;
    }


    @Override
    public int getChildrenCount(int groupPosition) {
        return mStatsData.get(groupPosition).childItemData.size();
    }

    @Override
    public NFLMatch getChild(int groupPosition, int childPosition) {
        return mStatsData.get(groupPosition).childItemData.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View childRowView = convertView;
        final ChildItemHolder itemHolder;
        if (childRowView == null) {
            itemHolder = new ChildItemHolder();
            childRowView = mLayoutInflater.inflate(R.layout.layout_team_details, parent, false);

            itemHolder.tvLeftTeamName = (TextView) childRowView.findViewById(R.id.tv_left_team_name);
            itemHolder.tvRightTeamName = (TextView) childRowView.findViewById(R.id.tv_right_team_name);
            itemHolder.llTeamAPanel = (LinearLayout) childRowView.findViewById(R.id.ll_team_a_panel);
            itemHolder.llTeamBPanel = (LinearLayout) childRowView.findViewById(R.id.ll_team_b_panel);

            childRowView.setTag(itemHolder);
        } else {
            itemHolder = (ChildItemHolder) childRowView.getTag();
        }

        NFLMatch childData = getChild(groupPosition, childPosition);

        if (childData.teamA != null) {
            itemHolder.tvLeftTeamName.setText(TextUtils.getValidText(childData.teamA.name));
            LayoutUtil.inflateTopPlayers((Activity) mContext, childData.teamA.topPlayers, childData.teamA.id, itemHolder.llTeamAPanel);
        }

        if (childData.teamB != null) {
            itemHolder.tvRightTeamName.setText(TextUtils.getValidText(childData.teamB.name));
            LayoutUtil.inflateTopPlayers((Activity) mContext, childData.teamB.topPlayers, childData.teamB.id, itemHolder.llTeamBPanel);
        }

        return childRowView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class SectionHolder {
        TextView tvSectionTitle;
    }

    private class ChildItemHolder {
        TextView tvLeftTeamName, tvRightTeamName;
        LinearLayout llTeamAPanel, llTeamBPanel;
    }
}
