package com.company.Equipment.Armor;

public class Shield extends Armor {

    public Shield(String name, int cost, int weight, Armor_Type type, int armor) {
        super(name, cost, weight, type, armor);
    }

    public Shield(){
        super("Shield",10,6,Armor_Type.SHIELD,2);
    }
}
