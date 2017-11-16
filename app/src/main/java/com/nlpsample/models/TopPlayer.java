package com.nlpsample.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TopPlayer implements Serializable
{
    private final static long serialVersionUID = 3335011827914593205L;
    public String id;
    public String position;
    @SerializedName("full_name")
    public String fullName;
    @SerializedName("short_name")
    public String shortName;
    @SerializedName("stat_value")
    public int statValue;
    @SerializedName("jumper_number")
    public int jumperNumber;
}
