package com.company.Equipment.Armor.Medium_Armor;

public class HalfPlate extends MediumArmor {

    public HalfPlate(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public HalfPlate(){
        this("Half Plate", 750, 40, 5);
    }
}
