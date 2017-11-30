package com.company.Equipment.Armor.Medium_Armor;

public class ScaleMail extends MediumArmor {
    public ScaleMail(String name, int cost, int weight, int armor) {
        super(name, cost, weight, armor);
    }

    public ScaleMail(){
        this("Scale Mail", 50, 45, 4);
    }
}
