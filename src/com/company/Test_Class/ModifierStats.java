package com.company.Test_Class;

/**
 * Created by ble on 12/26/2017.
 */

public class ModifierStats {

    private String name;
    private int finalModifier;

    public ModifierStats(String name, BaseStats baseStats) {
        this.name = name;
        calculateFinalModifier(baseStats);
    }


    public int getFinalModifier() {
        return finalModifier;
    }

    public String getName(){
        return name;
    }

    public void calculateFinalModifier(BaseStats baseStats){
        this.finalModifier = (baseStats.getFinalStats()-10)/2;
    }
}
