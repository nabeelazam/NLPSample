package com.nlpsample.models;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LastMatchStats implements Serializable
{
    private final static long serialVersionUID = 3626005851713977762L;

    public String errors;
    public String goals;
    public String intercepted;
    public String intercepts;
    public String kicks;
    public String points;
    public String possessions;
    public String runs;
    public String tackles;
    public String tries;
    @SerializedName("mins_played")
    public String minsPlayed;
    @SerializedName("attacking_kicks")
    public String attackingKicks;
    @SerializedName("bombs_caught")
    public String bombsCaught;
    @SerializedName("bombs_dropped")
    public String bombsDropped;
    @SerializedName("charged_down")
    public String chargedDown;
    @SerializedName("charges_down")
    public String chargesDown;
    @SerializedName("drop_outs")
    public String dropOuts;
    @SerializedName("dummy_half_runs")
    public String dummyHalfRuns;
    @SerializedName("effective_offloads")
    public String effectiveOffloads;
    @SerializedName("fantasy_points")
    public String fantasyPoints;
    @SerializedName("field_goal_attempts")
    public String fieldGoalAttempts;
    @SerializedName("field_goal_misses")
    public String fieldGoalMisses;
    @SerializedName("field_goals")
    public String fieldGoals;
    @SerializedName("forced_drop_outs")
    public String forcedDropOuts;
    @SerializedName("general_play_pass")
    public String generalPlayPass;
    @SerializedName("goal_misses")
    public String goalMisses;
    @SerializedName("ineffective_tackles")
    public String ineffectiveTackles;
    @SerializedName("in_goal_escapes")
    public String inGoalEscapes;
    @SerializedName("interchanges_off")
    public String interchangesOff;
    @SerializedName("interchanges_on")
    public String interchangesOn;
    @SerializedName("kick_errors")
    public String kickErrors;
    @SerializedName("kick_metres")
    public String kickMetres;
    @SerializedName("kick_return_metres")
    public String kickReturnMetres;
    @SerializedName("kick_returns")
    public String kickReturns;
    @SerializedName("kicks_4020")
    public String kicks4020;
    @SerializedName("kicks_dead")
    public String kicksDead;
    @SerializedName("last_touch_try_assists")
    public String lastTouchTryAssists;
    @SerializedName("line_break_assists")
    public String lineBreakAssists;
    @SerializedName("line_break_causes")
    public String lineBreakCauses;
    @SerializedName("line_breaks")
    public String lineBreaks;
    @SerializedName("line_engagements")
    public String lineEngagements;
    @SerializedName("long_kicks")
    public String longKicks;
    @SerializedName("missed_tackles")
    public String missedTackles;
    @SerializedName("off_loads")
    public String offLoads;
    @SerializedName("one_pass_runs")
    public String onePassRuns;
    @SerializedName("penalties_conceded")
    public String penaltiesConceded;
    @SerializedName("play_the_balls")
    public String playTheBalls;
    @SerializedName("run_metres")
    public String runMetres;
    @SerializedName("runs_7less_meters")
    public String runs7lessMeters;
    @SerializedName("runs_8plus_meters")
    public String runs8plusMeters;
    @SerializedName("send_offs")
    public String sendOffs;
    @SerializedName("sin_bins")
    public String sinBins;
    @SerializedName("steals_one_on_one")
    public String stealsOneOnOne;
    @SerializedName("stolen_one_on_one")
    public String stolenOneOnOne;
    @SerializedName("tackle_busts")
    public String tackleBusts;
    @SerializedName("tackled_opp20")
    public String tackledOpp20;
    @SerializedName("tackle_opp_half")
    public String tackleOppHalf;
    @SerializedName("tackles_one_on_one")
    public String tacklesOneOnOne;
    @SerializedName("try_assists")
    public String tryAssists;
    @SerializedName("try_causes")
    public String tryCauses;
    @SerializedName("try_contribution_percentage")
    public String tryContributionPercentage;
    @SerializedName("try_contributions")
    public String tryContributions;
    @SerializedName("try_involvements")
    public String tryInvolvements;
    @SerializedName("twenty_metre_restarts")
    public String twentyMetreRestarts;
    @SerializedName("weighted_kicks")
    public String weightedKicks;
}
