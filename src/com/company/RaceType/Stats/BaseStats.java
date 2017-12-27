package com.company.RaceType.Stats;

import java.util.ArrayList;

/**
 * Created by ble on 12/26/2017.
 */

public class BaseStats {

    public ArrayList<BonusStats> tempStats;

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

    public int getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(int baseStats) {
        this.baseStats += baseStats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFinalStats() {
        return finalStats;
    }

    public void addAdditiveBonus(BonusStats bonusStats){
        tempStats.add(bonusStats);
    }

    public void removeAdditiveBonus(BonusStats bonusStats){
        tempStats.remove(bonusStats);
    }

    public int calculateFinalStats(){
        this.finalStats = baseStats;
        this.tempStats.forEach(x -> this.finalStats += x.getBonusStats());
        return this.finalStats;
    }
}


