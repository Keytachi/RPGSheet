package com.company.Equipment.Armor.Medium_Armor;

public class Breastplate extends MediumArmor {

    public Breastplate(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public Breastplate(){
        this("Breast Plate", 400, 20, 14);
    }
}
