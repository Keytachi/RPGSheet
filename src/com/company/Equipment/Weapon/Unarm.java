package com.company.Equipment.Weapon;

import com.company.Util.dice;

public class Unarm extends Weapon {

    public Unarm() {
        super(0, 0, "Unarm", Damage_Type.BLUDGEONING, new dice(4));
    }
}
