package com.company.Equipment.Armor;

import com.company.Equipment.Equipment;
import com.company.RaceType.Race;

public abstract class Armor extends Equipment {

    protected int armor;

    public Armor(String name, int cost, int weight, int armor) {
        super(name, cost, weight);
        this.armor = armor;
    }

    public int get_Armor(){
        return this.armor;
    }
    public int getArmorAmount(Race person){
        return get_Armor();
    }

    public void requirement(Race person){

    }
}
