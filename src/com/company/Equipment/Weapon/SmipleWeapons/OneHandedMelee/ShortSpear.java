package com.company.Equipment.Weapon.SmipleWeapons.OneHandedMelee;

import com.company.Equipment.Weapon.SmipleWeapons.SimpleWeapon;
import com.company.Util.dice;

public class ShortSpear extends SimpleWeapon {

    public ShortSpear(int weight, int cost, String name) {
        super(weight, cost, name, Damage_Type.PIERCING, new dice(6));
    }

    public ShortSpear(){
        this(3,1,"Short Spear");
    }
}
