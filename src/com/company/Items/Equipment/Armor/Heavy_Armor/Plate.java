package com.company.Items.Equipment.Armor.Heavy_Armor;

public class Plate extends AHeavy {

    public Plate(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public Plate(){
        this("Plate Armor", 1500,65,8);
    }
}
