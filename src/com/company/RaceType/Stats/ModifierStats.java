package com.company.RaceType.Stats;

import com.company.CharacterPanel.CharacterInformation;

/**
 * Created by ble on 12/26/2017.
 */

public class ModifierStats {

    private int finalModifier;

    public ModifierStats(CharacterInformation baseStats){
        calculateFinalModifier(baseStats);
    }


    public int getFinalModifier() {
        return finalModifier;
    }

    public void calculateFinalModifier(CharacterInformation baseStats){
        this.finalModifier = (baseStats.getFinalValue()-10)/2;
    }
}
