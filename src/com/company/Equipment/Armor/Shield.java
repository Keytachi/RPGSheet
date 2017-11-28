package com.company.Equipment.Armor;

public class Shield extends Armor {

    public Shield(String name, int cost, int weight, int armor) {
        super(name, cost, weight, Armor_Type.SHIELD, armor);
    }

    public Shield(){
        this("Shield",10,6,2);
    }
}
