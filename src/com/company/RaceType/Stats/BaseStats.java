package com.company.RaceType.Stats;

import com.company.Spell.Effect;

import java.util.ArrayList;

/**
 * Created by ble on 12/26/2017.
 */

public class BaseStats {

    public ArrayList<Effect> tempStats;

    private int baseStats;
    private String name;
    private int finalStats;


    public BaseStats(int baseStats, String name) {
        this.baseStats = baseStats;
        this.name = name;
        this.tempStats = new ArrayList<>();
        calculateFinalStats();
    }

    public BaseStats(int baseStats){
        this.baseStats = baseStats;
        this.tempStats = new ArrayList<>();
        calculateFinalStats();
    }

    public ArrayList<Effect> getTempStats(){
        return this.tempStats;
    }

    public void setBaseStats(int baseStats) {
        this.baseStats += baseStats;
    }

    public String getName() {
        return name;
    }


    public int getFinalStats() {
        return calculateFinalStats();
    }

    public void addAdditiveBonus(Effect bonusStats){
        tempStats.add(bonusStats);
    }

    public void removeAdditiveBonus(Effect bonusStats){
        tempStats.remove(bonusStats);
    }

    private int calculateFinalStats(){
        this.finalStats = baseStats;
        this.tempStats.forEach(x -> this.finalStats += x.getStatsRate());
        return this.finalStats;
    }
}


