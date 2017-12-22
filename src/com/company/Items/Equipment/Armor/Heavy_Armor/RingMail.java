package com.company.Items.Equipment.Armor.Heavy_Armor;

import com.company.PlayerCharacter;

public class RingMail extends HeavyArmor{
    public RingMail(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public RingMail(){
        this("Ring Mail", 30, 40, 4);
    }


    //No get_Requirement for this heavy armor type so overriding it to not weight down the user.
    @Override
    public void get_Requirement(PlayerCharacter person){

    }
}
