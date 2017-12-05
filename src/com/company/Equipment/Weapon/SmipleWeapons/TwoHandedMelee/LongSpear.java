package com.company.Equipment.Weapon.SmipleWeapons.TwoHandedMelee;

import com.company.Equipment.Weapon.SmipleWeapons.SimpleWeapon;
import com.company.Util.dice;

public class LongSpear extends SimpleTwoHand {

    public LongSpear(int weight, int cost, String name) {
        super(weight, cost, name, Damage_Type.PIERCING, new dice(8));
    }

    public LongSpear(){
        this(9,5,"Long Spear");
    }
}
