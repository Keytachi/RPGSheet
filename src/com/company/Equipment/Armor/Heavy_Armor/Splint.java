package com.company.Equipment.Armor.Heavy_Armor;

public class Splint extends HeavyArmor {
    public Splint(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public Splint(){
        this("Splint", 200, 60, 7);
    }
}
