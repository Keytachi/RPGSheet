package com.company.Equipment.Weapon.SmipleWeapons.OneHandedMelee;

import com.company.Equipment.Weapon.SmipleWeapons.SimpleWeapon;
import com.company.Util.dice;

public class Club extends SimpleWeapon {

    public Club(int weight, int cost, String name) {
        super(weight, cost, name, Damage_Type.BLUDGEONING, new dice(6));
    }

    public Club(){
        this(3,0,"Club");
    }
}
