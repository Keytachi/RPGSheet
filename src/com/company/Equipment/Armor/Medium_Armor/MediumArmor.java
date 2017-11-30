package com.company.Equipment.Armor.Medium_Armor;

import com.company.Equipment.Armor.Armor;
import com.company.PlayerCharacter;
import com.company.RaceType.Race;

public abstract class MediumArmor extends Armor {
    public MediumArmor(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    @Override
    public int get_Armor(PlayerCharacter person){
        if(person.getRace().getDex_Modifier() > 2) return armor +2;
        return armor +person.getRace().getDex_Modifier();
    }
}
