package com.company.RaceType.Stats;

import com.company.CharacterPanel.Stats;

/**
 * Created by ble on 12/26/2017.
 */

public class ModifierStats {

    private int finalModifier;

    public ModifierStats(Stats baseStats){
        calculateFinalModifier(baseStats);
    }


    public int getFinalModifier() {
        return finalModifier;
    }

    public void calculateFinalModifier(Stats baseStats){
        this.finalModifier = (baseStats.getFinalValue()-10)/2;
    }
}
