package com.company.Equipment.Weapon;

import com.company.Equipment.Equipment;
import com.company.Util.dice;

public abstract class Weapon extends Equipment {

    protected enum Damage_Type{
        BLUDGEONING,
        PIERCING,
        SLASHING
    }

    private dice damage_Die;
    private Damage_Type type;

    public Weapon(int weight, int cost, String name, Damage_Type type,dice damage_Die) {
        super(name,cost,weight);
        this.type = type;
        this.damage_Die = damage_Die;
    }

    public Damage_Type getType() {
        return type;
    }

    public dice getDamage_Die() {
        return damage_Die;
    }
}
