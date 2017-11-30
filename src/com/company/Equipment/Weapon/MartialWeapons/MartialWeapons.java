package com.company.Equipment.Weapon.MartialWeapons;

import com.company.Equipment.Weapon.Weapon;
import com.company.Util.dice;

public class MartialWeapons extends Weapon {

    public MartialWeapons(int weight, int cost, String name, Damage_Type type, dice damage_Die) {
        super(weight, cost, name, type, damage_Die);
    }
}
