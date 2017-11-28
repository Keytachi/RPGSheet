package com.company.Equipment.Armor.Light_Armor;

import com.company.Equipment.Armor.Armor;
import com.company.RaceType.Race;

public abstract class LightArmor extends Armor {

    public LightArmor(String name, int cost, int weight, int armor) {
        super(name, cost, weight, Armor_Type.LIGHT, armor);
    }

    @Override
    public int getArmorAmount(Race person){
        return get_Armor()+person.getDex_Modifier();
    }
}
