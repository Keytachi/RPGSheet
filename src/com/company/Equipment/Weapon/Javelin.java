package com.company.Equipment.Weapon;

import com.company.Util.dice;

public class Javelin extends Weapon {

    public Javelin(int weight, int cost, String name) {
        super(weight, cost, name, Damage_Type.PIERCING,
                new dice(6));
    }

    public Javelin(){
        this(2, 5, "Javelin");
    }
}
