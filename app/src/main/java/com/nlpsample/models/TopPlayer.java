package com.nlpsample.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TopPlayer implements Serializable
{
    private final static long serialVersionUID = 3335011827914593205L;
    @SerializedName("id")
    private int id;
    @SerializedName("position")
    private String position;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("short_name")
    private String shortName;
    @SerializedName("stat_value")
    private int statValue;
    @SerializedName("jumper_number")
    private int jumperNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getStatValue() {
        return statValue;
    }

    public void setStatValue(int statValue) {
        this.statValue = statValue;
    }

    public int getJumperNumber() {
        return jumperNumber;
    }

    public void setJumperNumber(int jumperNumber) {
        this.jumperNumber = jumperNumber;
    }

}
