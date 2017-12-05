package com.company.ClassType;

import com.company.Equipment.Armor.Armor;
import com.company.PlayerCharacter;
import com.company.RaceType.Race;
import com.company.Util.EnumContainer;
import com.company.Util.dice;

import java.util.Map;

public class Wizard extends ClassRole {


    public Wizard(){
        super(new dice(6));
    }

    @Override
    public String toString(){
        return "Wizard";
    }

    @Override
    public int get_ArmorProficiency(Map gearEquipment, EnumContainer.GearSlot gearSlot){
        return 0;
    }
}