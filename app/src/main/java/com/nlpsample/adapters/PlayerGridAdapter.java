package com.nlpsample.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nlpsample.R;
import com.nlpsample.utils.LayoutUtil;
import com.nlpsample.utils.TextUtils;

import java.util.LinkedHashMap;

public class PlayerGridAdapter extends BaseAdapter {

    private Context mContext;
    private LinkedHashMap<String, String> mData;
    private LayoutInflater mInflater;
    private String[] mKeys;

    public PlayerGridAdapter(Context ctx, LinkedHashMap<String, String> data) {
        this.mContext = ctx;
        this.mData = data;
        this.mInflater = LayoutUtil.getLayoutInflater(mContext);
        mKeys = mData.keySet().toArray(new String[data.size()]);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(mKeys[position]);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        View rowView = convertView;
        final PlayerViewHolder itemHolder;
        if (rowView == null) {
            itemHolder = new PlayerViewHolder();
            rowView = mInflater.inflate(R.layout.player_grid_item, viewGroup, false);
            itemHolder.tvStatValue = (TextView) rowView.findViewById(R.id.tv_custom_label);

            rowView.setTag(itemHolder);
        } else {
            itemHolder = (PlayerViewHolder) rowView.getTag();
        }

        String key = mKeys[position];
        String value = getItem(position).toString();

        itemHolder.tvStatValue.setText(TextUtils.getDifferentFontText(key + ": ", value));

        return rowView;
    }

    private class PlayerViewHolder {
        TextView tvStatValue;
    }
}
