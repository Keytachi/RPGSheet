package com.company.Items.Equipment.Armor.Heavy_Armor;

public class Splint extends AHeavy {
    public Splint(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public Splint(){
        this("Splint", 200, 60, 7);
    }
}
