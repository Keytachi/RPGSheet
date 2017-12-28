package com.company.Items.Equipment.Armor.Medium_Armor;

public class Breastplate extends AMedium {

    public Breastplate(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public Breastplate(){
        this("Breast Plate", 400, 20, 4);
    }
}
