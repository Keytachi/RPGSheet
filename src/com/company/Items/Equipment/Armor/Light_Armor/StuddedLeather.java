package com.company.Items.Equipment.Armor.Light_Armor;

public class StuddedLeather extends ALight {

    public StuddedLeather(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public StuddedLeather(){
        this("Studded Leather", 45, 13, 2);
    }
}
