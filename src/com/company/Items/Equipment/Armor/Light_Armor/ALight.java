package com.company.Items.Equipment.Armor.Light_Armor;

import com.company.Items.Equipment.Armor.AArmor;
import com.company.Character.PlayerCharacter;
import com.company.RaceType.Stats.AttributeEnum.AttributeModify;

public abstract class ALight extends AArmor {

    public ALight(String name, int cost, int weight, int armor) {
        super(armor, cost, weight, name);
    }

    @Override
    public int get_Armor(PlayerCharacter person){
        return person.get_Race().getModifierStats(AttributeModify.Dex_Modifier).getFinalModifier() + armor;
    }
}
