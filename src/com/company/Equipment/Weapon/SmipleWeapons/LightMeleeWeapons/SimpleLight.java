package com.company.Equipment.Weapon.SmipleWeapons.LightMeleeWeapons;

import com.company.Equipment.Weapon.SmipleWeapons.SimpleWeapon;
import com.company.Util.dice;

public abstract class SimpleLight extends SimpleWeapon{

    public SimpleLight(int weight, int cost, String name, Damage_Type type, dice damage_Die) {
        super(weight, cost, name, type, damage_Die);
    }
}
