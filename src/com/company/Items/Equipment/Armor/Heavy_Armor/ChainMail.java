package com.company.Items.Equipment.Armor.Heavy_Armor;

import com.company.Character.PlayerCharacter;

public class ChainMail extends HeavyArmor {
    public ChainMail(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public ChainMail(){
        this("Chain Mail", 75, 55, 4);
    }

    //Strength get_Requirement for this armor is 13 instead of the 15.
    @Override
    public void get_Requirement(PlayerCharacter person){
        if(person.getRace().getStrength() < 13) person.getRace().set_WalkingSpeed(person.getRace().get_WalkingSpeed()-10);
    }
}
