package com.company.Equipment.Armor.Light_Armor;

public class Padded extends LightArmor {

    public Padded(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public Padded(){
        this("Padded Armor", 5, 8,1);
    }
}
