package com.company.Test_Class;

import com.company.Util.dice;

/**
 * Created by ble on 12/26/2017.
 */

public class Test_Elf extends Test_Race {
    public Test_Elf(int str_value, int dex_value, int cons_value, int int_value, int wis_value, int char_value) {
        super(str_value, dex_value, cons_value, int_value, wis_value, char_value);
        //displayStats();
        //specialty();
    }

    public Test_Elf(){
        this(dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4),dice.rollStats(6,4));
    }

    public void specialty(){
        baseStats.get(1).setBaseStats(2);
        baseStats.get(1).calculateFinalStats();
        modifyStats.get(1).calculateFinalModifier(baseStats.get(1));

    }
}
