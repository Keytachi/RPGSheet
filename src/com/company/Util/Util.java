package com.company.Util;


import com.company.CharacterPanel.CharacterInformation;
import com.company.RaceType.Stats.AttributeEnum;
import com.company.RaceType.Stats.ModifierStats;

import java.util.HashMap;

public final class Util {


    public static final boolean gearisInstance(Object current_GearSlot, Class<?> gear_Compare){
        return gear_Compare.isInstance(current_GearSlot);
    }

    public static int getValue(HashMap<?,CharacterInformation> map, Enum<?> key){
        return map.get(key).getFinalValue();
    }

    public static int getValue(HashMap<?, ModifierStats> map, AttributeEnum.AttributeModify key){
        return map.get(key).getFinalModifier();
    }
}
