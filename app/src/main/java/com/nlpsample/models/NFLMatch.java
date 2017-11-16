package com.nlpsample.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NFLMatch implements Serializable
{
    private final static long serialVersionUID = -587189622453271706L;

    @SerializedName("match_id")
    public String matchId;
    @SerializedName("team_A")
    public Team teamA;
    @SerializedName("team_B")
    public Team teamB;
    @SerializedName("stat_type")
    public String statType;
}