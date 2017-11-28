package com.company.Equipment.Armor;

import com.company.Equipment.Equipment;

public abstract class Armor extends Equipment {

    protected  enum Armor_Type{
        LIGHT,
        MEDIUM,
        HEAVEY,
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

    public int getArmor() {
        return armor;
    }
}
