package com.company.Equipment.Armor.Light_Armor;

import com.company.Equipment.Armor.Armor;
import com.company.PlayerCharacter;
import com.company.RaceType.Race;

public abstract class LightArmor extends Armor {

    public LightArmor(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    @Override
    public int get_Armor(PlayerCharacter person){
        return person.getRace().getDex_Modifier() + armor;
    }
}
