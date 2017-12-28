package com.company.Items.Equipment.Armor.Light_Armor;

public class Padded extends ALight {

    public Padded(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public Padded(){
        this("Padded Armor", 5, 8,1);
    }
}
