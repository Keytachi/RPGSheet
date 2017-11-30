package com.company.Equipment.Weapon.SmipleWeapons.LightMeleeWeapons;

import com.company.Equipment.Weapon.SmipleWeapons.SimpleWeapon;
import com.company.Util.dice;

public class Sickle extends SimpleWeapon {

    public Sickle(int weight, int cost, String name) {
        super(weight, cost, name, Damage_Type.SLASHING, new dice(6));
    }

    public Sickle(){
        this(2,6,"Sickle");
    }
}
