package com.company.Equipment.Weapon.SmipleWeapons.OneHandedMelee;

import com.company.Equipment.Weapon.SmipleWeapons.SimpleWeapon;
import com.company.Util.dice;

public abstract class SimpleOneHand extends SimpleWeapon {

    public SimpleOneHand(int weight, int cost, String name, Damage_Type type, dice damage_Die) {
        super(weight, cost, name, type, damage_Die);
    }
}
