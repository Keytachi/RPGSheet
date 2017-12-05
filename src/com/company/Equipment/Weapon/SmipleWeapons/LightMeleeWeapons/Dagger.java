package com.company.Equipment.Weapon.SmipleWeapons.LightMeleeWeapons;

import com.company.Util.dice;

public class Dagger extends SimpleLight {

    public Dagger(int weight, int cost, String name) {
        super(weight, cost, name, Damage_Type.PIERCING, new dice(4));
    }

    public Dagger(){
        this(1,2,"Dagger");
    }
}
