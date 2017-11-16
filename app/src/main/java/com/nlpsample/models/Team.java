package com.nlpsample.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable
{
    private final static long serialVersionUID = 7348560445587515557L;
    public String id;
    public String name;
    public String code;
    @SerializedName("short_name")
    public String shortName;
    @SerializedName("top_players")
    public ArrayList<TopPlayer> topPlayers = null;
}