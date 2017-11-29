package com.company.Equipment.Weapon;

import com.company.Equipment.Weapon.Weapon;

public class Shield extends Weapon {

    public Shield(String name, int cost, int weight, int armor) {
        super(weight, cost, name, Damage_Type.DEFENSE, null);
        this.armor = armor;
    }

    public Shield(){
        this("Shield",10,6,2);
    }
}
