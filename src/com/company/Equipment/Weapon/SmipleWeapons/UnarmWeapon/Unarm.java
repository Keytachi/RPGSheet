package com.company.Equipment.Weapon.SmipleWeapons.UnarmWeapon;

import com.company.Equipment.Weapon.SmipleWeapons.SimpleWeapon;
import com.company.Util.dice;

public class Unarm extends SimpleUnarm {

    public Unarm() {
        super(0, 0, "Unarm", Damage_Type.BLUDGEONING, new dice(4));
    }
}
