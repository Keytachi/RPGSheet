package com.company.Equipment.Weapon.SmipleWeapons.OneHandedMelee;

import com.company.Util.dice;

public class MorningStar extends SimpleOneHand {

    public MorningStar(int weight, int cost, String name) {
        super(weight, cost, name, Damage_Type.PIERCING, new dice(8));
    }

    public MorningStar(){
        this(6,8,"Morning Star");
    }
}
