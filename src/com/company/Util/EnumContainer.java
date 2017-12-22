package com.company.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EnumContainer {

    public enum GearSlot{
                ARMOR,
                LHAND,
                RHAND
    }

    public static Set<GearSlot> weapon_Slot = new HashSet<>(Arrays.asList(GearSlot.LHAND,GearSlot.RHAND));

}
