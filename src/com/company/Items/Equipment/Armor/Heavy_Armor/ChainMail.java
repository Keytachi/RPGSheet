package com.company.Items.Equipment.Armor.Heavy_Armor;

import com.company.Character.PlayerCharacter;
import com.company.RaceType.Stats.AttributeEnum.Attribute;

public class ChainMail extends AHeavy {
    public ChainMail(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public ChainMail(){
        this("Chain Mail", 75, 55, 4);
    }

    //Strength get_Requirement for this armor is 13 instead of the 15.
    @Override
    public void get_Requirement(PlayerCharacter person){
        if(person.get_Race().getAttributeStatsValue(Attribute.Strength) < 13)
            person.get_Movement().increaseBaseValue(person.get_Movement().getFinalValue() - 10);
    }
}
