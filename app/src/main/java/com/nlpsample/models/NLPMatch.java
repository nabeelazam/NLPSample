package com.nlpsample.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NLPMatch implements Serializable
{
    private final static long serialVersionUID = -587189622453271706L;

    @SerializedName("match_id")
    private String matchId;
    @SerializedName("team_A")
    private Team teamA;
    @SerializedName("team_B")
    private Team teamB;
    @SerializedName("stat_type")
    private String statType;

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }

}