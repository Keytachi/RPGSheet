package com.company.Items.Equipment.Armor.Medium_Armor;

import com.company.Items.Equipment.Armor.Abstract_Armor;
import com.company.Character.PlayerCharacter;

public abstract class MediumArmor extends Abstract_Armor {
    public MediumArmor(String name, int cost, int weight, int armor) {
        super(armor, cost, weight, name);
    }

    @Override
    public int get_Armor(PlayerCharacter person){
        if(person.getRace().getDex_Modifier() > 2) return armor +2;
        return armor +person.getRace().getDex_Modifier();
    }
}
