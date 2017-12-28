package com.company.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EnumContainer {

    public enum GearSlot{
                ARMOR("Body"),
                LHAND("Left Hand"),
                RHAND("Right Hand");

                private String name;
                GearSlot(String name){
                    this.name = name;
                }

                @Override
                public String toString(){
                    return this.name;
                }
    }

    public static Set<GearSlot> weapon_Slot = new HashSet<>(Arrays.asList(GearSlot.LHAND,GearSlot.RHAND));

}
