package com.company.Items.Equipment.Armor.Heavy_Armor;

import com.company.Items.Equipment.Armor.Abstract_Armor;
import com.company.Items.Equipment.Armor.Armor;
import com.company.PlayerCharacter;

public abstract class HeavyArmor extends Abstract_Armor {
    public HeavyArmor(String name, int cost, int weight, int armor) {
        super(armor, cost, weight, name);
    }

    @Override
    public void get_Requirement(PlayerCharacter person){
        if(person.getRace().getStrength() < 15) person.getRace().set_WalkingSpeed(person.getRace().get_WalkingSpeed()-10);
    }
    @Override
    public int get_Armor(PlayerCharacter person){
        return armor;
    }
}
