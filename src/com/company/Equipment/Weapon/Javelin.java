package com.company.Equipment.Weapon;

import com.company.Util.dice;

public class Javelin extends Weapon {

    public Javelin(int weight, int cost, String name, Weapon.Damage_Type type, dice damage_Die) {
        super(weight, cost, name, type, damage_Die);
    }

    public Javelin(){
        super(2, 5, "Javelin", Damage_Type.PIERCING, new dice(6));
    }
}
