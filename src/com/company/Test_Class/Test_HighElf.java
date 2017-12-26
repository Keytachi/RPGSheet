package com.company.Test_Class;

import com.company.RaceType.Elf;
import com.company.Util.dice;

/**
 * Created by ble on 12/26/2017.
 */

public class Test_HighElf extends Test_Elf {

    public Test_HighElf(int str_value, int dex_value, int cons_value, int int_value, int wis_value, int char_value){
        super(str_value, dex_value, cons_value, int_value, wis_value, char_value);
        displayStats();
        specialty();
    }
    public Test_HighElf() {
        this(dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4),dice.rollStats(6,4));
    }

    @Override
    public void specialty(){
        super.specialty();
        baseStats.get(3).setBaseStats(1);
        baseStats.get(3).calculateFinalStats();
        modifyStats.get(3).calculateFinalModifier(baseStats.get(3));
    }
}
