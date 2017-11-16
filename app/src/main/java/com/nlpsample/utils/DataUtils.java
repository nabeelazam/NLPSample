package com.nlpsample.utils;

import com.nlpsample.models.Player;

import java.util.LinkedHashMap;

public class DataUtils {

    /**
     * Function stores player data into a HashMap with values
     *
     * @param player
     * @return
     */
    public static LinkedHashMap<String, String> getLastMatchStats(Player player) {

        LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

        if (player != null && player.lastMatchStats != null) {

            dataMap.put("Errors", TextUtils.getValidText(player.lastMatchStats.errors));
            dataMap.put("Intercepted", TextUtils.getValidText(player.lastMatchStats.intercepted));
            dataMap.put("Intercepts", TextUtils.getValidText(player.lastMatchStats.intercepts));
            dataMap.put("Kicks", TextUtils.getValidText(player.lastMatchStats.kicks));
            dataMap.put("Points", TextUtils.getValidText(player.lastMatchStats.points));
            dataMap.put("Possessions", TextUtils.getValidText(player.lastMatchStats.possessions));
            dataMap.put("Runs", TextUtils.getValidText(player.lastMatchStats.runs));
            dataMap.put("Tackles", TextUtils.getValidText(player.lastMatchStats.tackles));
            dataMap.put("Min Played", TextUtils.getValidText(player.lastMatchStats.minsPlayed));
            dataMap.put("Attacking Kicks", TextUtils.getValidText(player.lastMatchStats.attackingKicks));
            dataMap.put("Bombs Caught", TextUtils.getValidText(player.lastMatchStats.bombsCaught));
            dataMap.put("Bombs Dropped", TextUtils.getValidText(player.lastMatchStats.bombsDropped));
            dataMap.put("Charged Down", TextUtils.getValidText(player.lastMatchStats.chargedDown));
            dataMap.put("Charges Down", TextUtils.getValidText(player.lastMatchStats.chargesDown));
            dataMap.put("Drops Outs", TextUtils.getValidText(player.lastMatchStats.dropOuts));
            dataMap.put("Dummy Half Runs", TextUtils.getValidText(player.lastMatchStats.dummyHalfRuns));
            dataMap.put("Effective Offloads", TextUtils.getValidText(player.lastMatchStats.effectiveOffloads));
            dataMap.put("Fantasy Points", TextUtils.getValidText(player.lastMatchStats.fantasyPoints));
            dataMap.put("Field Goal Attempts", TextUtils.getValidText(player.lastMatchStats.fieldGoalAttempts));
            dataMap.put("Field Goal Misses", TextUtils.getValidText(player.lastMatchStats.fieldGoalMisses));
            dataMap.put("Field Goals", TextUtils.getValidText(player.lastMatchStats.fieldGoals));
            dataMap.put("Forced Drop Outs", TextUtils.getValidText(player.lastMatchStats.forcedDropOuts));
            dataMap.put("General Play Pass", TextUtils.getValidText(player.lastMatchStats.generalPlayPass));
            dataMap.put("Goal Misses", TextUtils.getValidText(player.lastMatchStats.goalMisses));
            dataMap.put("Ineffective Tackles", TextUtils.getValidText(player.lastMatchStats.ineffectiveTackles));
            dataMap.put("In Goal Escapes", TextUtils.getValidText(player.lastMatchStats.inGoalEscapes));
            dataMap.put("Interchanges Off", TextUtils.getValidText(player.lastMatchStats.interchangesOff));
            dataMap.put("Interchanges On", TextUtils.getValidText(player.lastMatchStats.interchangesOn));
            dataMap.put("Kick Errors", TextUtils.getValidText(player.lastMatchStats.kickErrors));
            dataMap.put("Kick Metres", TextUtils.getValidText(player.lastMatchStats.kickMetres));
            dataMap.put("Kick Return Meters", TextUtils.getValidText(player.lastMatchStats.kickReturnMetres));
            dataMap.put("Kick Returns", TextUtils.getValidText(player.lastMatchStats.kickReturns));
            dataMap.put("Kicks 4020", TextUtils.getValidText(player.lastMatchStats.kicks4020));
            dataMap.put("Kicks Dead", TextUtils.getValidText(player.lastMatchStats.kicksDead));
            dataMap.put("Last Touch Try Assists", TextUtils.getValidText(player.lastMatchStats.lastTouchTryAssists));
            dataMap.put("Line Break Assists", TextUtils.getValidText(player.lastMatchStats.lineBreakAssists));
            dataMap.put("Line Break Causes", TextUtils.getValidText(player.lastMatchStats.lineBreakCauses));
            dataMap.put("Line Breaks", TextUtils.getValidText(player.lastMatchStats.lineBreaks));
            dataMap.put("Line Engagements", TextUtils.getValidText(player.lastMatchStats.lineEngagements));
            dataMap.put("Long Kicks", TextUtils.getValidText(player.lastMatchStats.longKicks));
            dataMap.put("Missed Tackles", TextUtils.getValidText(player.lastMatchStats.missedTackles));
            dataMap.put("Off Loads", TextUtils.getValidText(player.lastMatchStats.offLoads));
            dataMap.put("One Pass Runs", TextUtils.getValidText(player.lastMatchStats.onePassRuns));
            dataMap.put("Penalties Conceded", TextUtils.getValidText(player.lastMatchStats.penaltiesConceded));
            dataMap.put("Play the Balls", TextUtils.getValidText(player.lastMatchStats.playTheBalls));
            dataMap.put("Run Meters", TextUtils.getValidText(player.lastMatchStats.runMetres));
            dataMap.put("Runs 7Less Meters", TextUtils.getValidText(player.lastMatchStats.runs7lessMeters));
            dataMap.put("Runs 8Plus Meters", TextUtils.getValidText(player.lastMatchStats.runs8plusMeters));
            dataMap.put("Send Offs", TextUtils.getValidText(player.lastMatchStats.sendOffs));
            dataMap.put("Sin Bins", TextUtils.getValidText(player.lastMatchStats.sinBins));
            dataMap.put("Steals One on One", TextUtils.getValidText(player.lastMatchStats.stealsOneOnOne));
            dataMap.put("Stolen One on One", TextUtils.getValidText(player.lastMatchStats.stolenOneOnOne));
            dataMap.put("Tackles Busts", TextUtils.getValidText(player.lastMatchStats.errors));
            dataMap.put("Tackled Opp20", TextUtils.getValidText(player.lastMatchStats.tackledOpp20));
            dataMap.put("Tackles Opp Half", TextUtils.getValidText(player.lastMatchStats.tackleOppHalf));
            dataMap.put("Tackles One on One", TextUtils.getValidText(player.lastMatchStats.tacklesOneOnOne));
            dataMap.put("Try Assists", TextUtils.getValidText(player.lastMatchStats.tryAssists));
            dataMap.put("Try Causes", TextUtils.getValidText(player.lastMatchStats.tryCauses));
            dataMap.put("Try Contributions Percentages", TextUtils.getValidText(player.lastMatchStats.tryContributionPercentage));
            dataMap.put("Try Contributions", TextUtils.getValidText(player.lastMatchStats.tryContributions));
            dataMap.put("Try Involvements", TextUtils.getValidText(player.lastMatchStats.tryInvolvements));
            dataMap.put("Twenty Metre Restarts", TextUtils.getValidText(player.lastMatchStats.twentyMetreRestarts));
            dataMap.put("Weighted Kicks", TextUtils.getValidText(player.lastMatchStats.weightedKicks));

        }
        return dataMap;
    }


}
