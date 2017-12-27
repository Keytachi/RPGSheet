package com.company.Items.Equipment.Armor.Heavy_Armor;

import com.company.Items.Equipment.Armor.Abstract_Armor;
import com.company.Character.PlayerCharacter;
import com.company.RaceType.Stats.AttributeEnum.Attribute;

public abstract class HeavyArmor extends Abstract_Armor {
    public HeavyArmor(String name, int cost, int weight, int armor) {
        super(armor, cost, weight, name);
    }

    @Override
    public void get_Requirement(PlayerCharacter person){
        if(person.get_Race().getBaseStats(Attribute.Strength).getFinalStats() < 15) person.get_Race().setWalking_Speed(person.get_Race().getWalking_Speed()-10);
    }
    @Override
    public int get_Armor(PlayerCharacter person){
        return armor;
    }
}
