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
        if(person.get_Race().getBaseStats(Attribute.Strength).getFinalValue() < 15) {
            person.getWalking_Speed().increaseBaseValue(person.getWalking_Speed().getFinalValue() - 10);
        }
    }
    @Override
    public int get_Armor(PlayerCharacter person){
        return armor;
    }
}
