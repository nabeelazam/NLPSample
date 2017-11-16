package com.nlpsample.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Player implements Serializable
{
    private final static long serialVersionUID = 1572552016896492122L;

    public int id;
    public String surname;
    public String position;

    @SerializedName("full_name")
    public String fullName;

    @SerializedName("short_name")
    public String shortName;

    @SerializedName("date_of_birth")
    public String dateOfBirth;

    @SerializedName("height_cm")
    public int heightCm;

    @SerializedName("other_names")
    public String otherNames;

    @SerializedName("weight_kg")
    public int weightKg;

    @SerializedName("last_match_id")
    public String lastMatchId;

    @SerializedName("last_match_stats")
    public LastMatchStats lastMatchStats;


}
