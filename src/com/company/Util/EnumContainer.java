package com.company.Util;

public class EnumContainer {

    public enum GearSlot{
                ARMOR,
                LHAND,
                RHAND
    }

    public static Enum<GearSlot> equipment_Slot[] = new Enum[]{
            GearSlot.ARMOR,
            GearSlot.LHAND,
            GearSlot.RHAND
    };
    public static Enum<GearSlot> weapon_Slot[] = new Enum[]{
        GearSlot.LHAND,
        GearSlot.RHAND
    };
}
