package com.company.Util;


import com.company.CharacterPanel.Stats;
import com.company.RaceType.Stats.AttributeEnum;
import com.company.RaceType.Stats.ModifierStats;

import java.util.HashMap;

public final class Util {


    public static final boolean gearisInstance(Object current_GearSlot, Class<?> gear_Compare){
        return gear_Compare.isInstance(current_GearSlot);
    }
}
