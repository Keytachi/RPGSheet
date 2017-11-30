package com.company.ClassType;

import com.company.Equipment.Armor.Armor;
import com.company.PlayerCharacter;
import com.company.RaceType.Race;
import com.company.Util.dice;

import java.util.Map;

public class Mage extends ClassRole {


    public Mage(){
        super(new dice(6));
    }

    @Override
    public void attack(Race player){

    }

    @Override
    public String toString(){
        return "Mage";
    }

    @Override
    public int get_ArmorProficiency(Map gearEquipment, PlayerCharacter.GearSlot gearSlot){
        return 0;
    }
}
