package com.company.Equipment.Weapon.SmipleWeapons.UnarmWeapon;

import com.company.Equipment.Weapon.SmipleWeapons.SimpleWeapon;
import com.company.Util.dice;

public class SimpleUnarm extends SimpleWeapon {

    public SimpleUnarm(int weight, int cost, String name, Damage_Type type, dice damage_Die) {
        super(weight, cost, name, type, damage_Die);
    }
}
