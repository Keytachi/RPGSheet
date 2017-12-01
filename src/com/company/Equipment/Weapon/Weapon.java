package com.company.Equipment.Weapon;

import com.company.Equipment.Equipment;
import com.company.Item;
import com.company.Util.dice;


public abstract class Weapon extends Equipment {

    public enum Damage_Type{
        BLUDGEONING,
        PIERCING,
        SLASHING,
    }

    private dice damage_Die;
    private Damage_Type type;

    public Weapon(int weight, int cost, String name, Damage_Type type,dice damage_Die) {
        super(weight,cost,name);
        this.type = type;
        this.damage_Die = damage_Die;
    }

    public Damage_Type getType() {
        return type;
    }

    public dice getDamage_Die() {
        return damage_Die;
    }

    //TODO: Rethink weapon system by using categories of Simple Melee, Simple Ranged Weapons,
    //TODO: Martial Melee Weapons,Martial Ranged Weapons, and Amunitions.

    public int attack(){
        return this.damage_Die.roll();
    }
}
