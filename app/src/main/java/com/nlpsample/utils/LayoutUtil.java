package com.nlpsample.utils;

import android.content.Context;
import android.view.LayoutInflater;

public class LayoutUtil {
    public static LayoutInflater getLayoutInflater(Context context) {
        if (context != null) {
            return (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        return null;
    }
}
