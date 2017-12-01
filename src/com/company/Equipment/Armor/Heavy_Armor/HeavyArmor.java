package com.company.Equipment.Armor.Heavy_Armor;

import com.company.Equipment.Armor.Armor;
import com.company.PlayerCharacter;
import com.company.RaceType.Race;

public abstract class HeavyArmor extends Armor {
    public HeavyArmor(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
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
