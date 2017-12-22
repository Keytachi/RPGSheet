package com.company.Items.Equipment.Armor.Light_Armor;

import com.company.Items.Equipment.Armor.Abstract_Armor;
import com.company.Items.Equipment.Armor.Armor;
import com.company.PlayerCharacter;

public abstract class LightArmor extends Abstract_Armor {

    public LightArmor(String name, int cost, int weight, int armor) {
        super(armor, cost, weight, name);
    }

    @Override
    public int get_Armor(PlayerCharacter person){
        return person.getRace().getDex_Modifier() + armor;
    }
}
