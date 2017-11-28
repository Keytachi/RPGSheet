package com.company.Equipment.Armor.Heavy_Armor;

import com.company.RaceType.Race;

public class ChainMail extends HeavyArmor {
    public ChainMail(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public ChainMail(){
        this("Chain Mail", 75, 55, 14);
    }

    //Strength requirement for this armor is 13 instead of the 15.
    @Override
    public void requirement(Race person){
        if(person.getStrength() < 13) person.set_WalkingSpeed(person.get_WalkingSpeed()-10);
    }
}
