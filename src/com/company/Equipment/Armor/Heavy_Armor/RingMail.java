package com.company.Equipment.Armor.Heavy_Armor;

import com.company.PlayerCharacter;
import com.company.RaceType.Race;

public class RingMail extends HeavyArmor{
    public RingMail(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public RingMail(){
        this("Ring Mail", 30, 40, 4);
    }


    //No requirement for this heavy armor type so overriding it to not weight down the user.
    @Override
    public void requirement(PlayerCharacter person){

    }
}
