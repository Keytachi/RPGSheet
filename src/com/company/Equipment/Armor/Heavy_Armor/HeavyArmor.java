package com.company.Equipment.Armor.Heavy_Armor;

import com.company.Equipment.Armor.Armor;
import com.company.RaceType.Race;

public abstract class HeavyArmor extends Armor {
    public HeavyArmor(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    @Override
    public void requirement(Race person){
        if(person.getStrength() < 15) person.set_WalkingSpeed(person.get_WalkingSpeed()-10);
    }
}
