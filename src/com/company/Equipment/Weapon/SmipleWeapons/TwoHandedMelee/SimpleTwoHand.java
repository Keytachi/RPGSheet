package com.company.Equipment.Weapon.SmipleWeapons.TwoHandedMelee;

import com.company.Equipment.Weapon.SmipleWeapons.SimpleWeapon;
import com.company.Util.dice;

public abstract class SimpleTwoHand extends SimpleWeapon {

    public SimpleTwoHand(int weight, int cost, String name, Damage_Type type, dice damage_Die) {
        super(weight, cost, name, type, damage_Die);
    }
}
