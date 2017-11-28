package com.company.Equipment.Armor;

import com.company.Equipment.Equipment;
import com.company.RaceType.Race;

public abstract class Armor extends Equipment {

    protected  enum Armor_Type{
        LIGHT,
        MEDIUM,
        HEAVY,
        SHIELD
    }

    protected Armor_Type type;
    protected int armor;

    public Armor(String name, int cost, int weight, Armor_Type type, int armor) {
        super(name, cost, weight);
        this.type = type;
        this.armor = armor;
    }

    public Armor_Type getType() {
        return type;
    }

    public int get_Armor(){
        return this.armor;
    }

    public int getArmorAmount(Race person){
        return get_Armor();
    }
}
