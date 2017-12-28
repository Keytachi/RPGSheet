package com.company.Items.Equipment.Armor.Medium_Armor;

public class Hide extends AMedium {

    public Hide(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public Hide(){
        this("Hide Armor", 10, 12, 2);
    }
}
