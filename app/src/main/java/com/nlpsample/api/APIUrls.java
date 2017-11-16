package com.nlpsample.api;


public class APIUrls {

    private static final String BASE_URL = "https://statsapi.foxsports.com.au/3.0/api/sports/league";

    /**
     * Assumption: Parameters can be passed but I am assuming it as a complete URL
     * @return
     */
    public static String getTopPlayerStatsUrl() {
        return BASE_URL + "/matches/NRL20172101/topplayerstats.json;type=fantasy_points;type=tackles;type=runs;type=run_metres?limit=5&userkey=A00239D3-45F6-4A0A-810C-54A347F144C2";
    }




}
