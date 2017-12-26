package com.company.Test_Class;

import com.company.Util.dice;

/**
 * Created by ble on 12/26/2017.
 */

public class Test_Human extends Test_Race {
    public Test_Human(int str_value, int dex_value, int cons_value, int int_value, int wis_value, int char_value) {
        super(str_value, dex_value, cons_value, int_value, wis_value, char_value);
        displayStats();
        specialty();
    }

    public Test_Human(){
        this(dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4),dice.rollStats(6,4));
    }

    public void specialty(){
        for(int i = 0; i < attributeList.length; i++){
            baseStats.get(i).additiveBonus.add(new BonusStats(1));
            baseStats.get(i).calculateFinalStats();
            modifyStats.get(i).calculateFinalModifier(baseStats.get(i));
        }

    }
}
