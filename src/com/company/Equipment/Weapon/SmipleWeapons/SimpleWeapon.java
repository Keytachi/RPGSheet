package com.company.Equipment.Weapon.SmipleWeapons;

import com.company.Equipment.Weapon.Weapon;
import com.company.Util.dice;

public class SimpleWeapon extends Weapon {

    public SimpleWeapon(int weight, int cost, String name, Damage_Type type, dice damage_Die) {
        super(weight, cost, name, type, damage_Die);
    }
}
