package com.company.Equipment.Weapon.SmipleWeapons.TwoHandedMelee;

import com.company.Equipment.Weapon.SmipleWeapons.SimpleWeapon;
import com.company.Util.dice;

public class QuarterStaff extends SimpleWeapon {

    public QuarterStaff(int weight, int cost, String name) {
        super(weight, cost, name, Damage_Type.BLUDGEONING, new dice(6));
    }
}
