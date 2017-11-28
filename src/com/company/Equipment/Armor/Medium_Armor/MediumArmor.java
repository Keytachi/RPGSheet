package com.company.Equipment.Armor.Medium_Armor;

import com.company.Equipment.Armor.Armor;
import com.company.RaceType.Race;

public abstract class MediumArmor extends Armor {
    public MediumArmor(String name, int cost, int weight, int armor) {
        super(name, cost, weight, Armor_Type.MEDIUM, armor);
    }

    @Override
    public int getArmorAmount(Race person){
        if(person.getDex_Modifier() > 2) return get_Armor()+2;
        return get_Armor()+person.getDex_Modifier();
    }
}
