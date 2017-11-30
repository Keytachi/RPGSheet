package com.company.Equipment.Armor.Heavy_Armor;

import com.company.PlayerCharacter;
import com.company.RaceType.Race;

public class ChainMail extends HeavyArmor {
    public ChainMail(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public ChainMail(){
        this("Chain Mail", 75, 55, 4);
    }

    //Strength requirement for this armor is 13 instead of the 15.
    @Override
    public void requirement(PlayerCharacter person){
        if(person.getRace().getStrength() < 13) person.getRace().set_WalkingSpeed(person.getRace().get_WalkingSpeed()-10);
    }
}
