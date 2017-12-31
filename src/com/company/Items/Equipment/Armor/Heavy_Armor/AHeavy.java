package com.company.Items.Equipment.Armor.Heavy_Armor;

import com.company.Items.Equipment.Armor.AArmor;
import com.company.Character.PlayerCharacter;
import com.company.RaceType.Stats.AttributeEnum.Attribute;

public abstract class AHeavy extends AArmor {
    public AHeavy(String name, int cost, int weight, int armor) {
        super(armor, cost, weight, name);
    }

    @Override
    public void get_Requirement(PlayerCharacter person){
        if(person.get_Race().getAttributeStatsValue(Attribute.Strength) < 15) {
            person.get_Movement().increaseBaseValue(person.get_Movement().getFinalValue() - 10);
        }
    }
    @Override
    public int getArmor(int dexModifier){
        return armor;
    }
}
