package com.company.Items.Equipment.Armor.Light_Armor;

public class Leather extends ALight {

    public Leather(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public Leather(){
        this("Leather Armor", 10, 10, 1);
    }
}
