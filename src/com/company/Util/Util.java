package com.company.Util;


public final class Util {
    public static final boolean gearNameMatch(Object current_GearSlot, Class<?> gear_Compare){
        return gear_Compare.isInstance(current_GearSlot);
    }
}
