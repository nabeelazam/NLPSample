package com.nlpsample.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable
{
    private final static long serialVersionUID = 7348560445587515557L;
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("code")
    private String code;
    @SerializedName("short_name")
    private String shortName;
    @SerializedName("top_players")
    private ArrayList<TopPlayer> topPlayers = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public ArrayList<TopPlayer> getTopPlayers() {
        return topPlayers;
    }

    public void setTopPlayers(ArrayList<TopPlayer> topPlayers) {
        this.topPlayers = topPlayers;
    }

}