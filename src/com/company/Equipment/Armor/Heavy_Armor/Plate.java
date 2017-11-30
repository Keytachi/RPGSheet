package com.company.Equipment.Armor.Heavy_Armor;

public class Plate extends HeavyArmor {

    public Plate(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public Plate(){
        this("Plate Armor", 1500,65,8);
    }
}
