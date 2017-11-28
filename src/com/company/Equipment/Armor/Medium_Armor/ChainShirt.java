package com.company.Equipment.Armor.Medium_Armor;

public class ChainShirt extends MediumArmor {
    public ChainShirt(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public ChainShirt(){
        this("Chain Armor", 50, 20, 13);
    }
}
