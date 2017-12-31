package com.company.Items.Equipment.Armor.Medium_Armor;

import com.company.Items.Equipment.Armor.AArmor;
import com.company.Character.PlayerCharacter;
import com.company.RaceType.Stats.AttributeEnum.AttributeModify;

public abstract class AMedium extends AArmor {
    public AMedium(String name, int cost, int weight, int armor) {
        super(armor, cost, weight, name);
    }

    @Override
    public int getArmor(int dexModifier){
        if(dexModifier > 2) return armor +2;
        return armor + dexModifier;
    }
}
