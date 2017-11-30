package com.company.Equipment.Weapon.SmipleWeapons.UnarmWeapon;

import com.company.Equipment.Weapon.SmipleWeapons.SimpleWeapon;
import com.company.Util.dice;

public class Gauntlet extends SimpleWeapon{

    public Gauntlet(int weight, int cost, String name, dice dice) {
        super(weight, cost, name, Damage_Type.BLUDGEONING, dice);
    }

    public Gauntlet() {
        this(0, 0, "Gauntlet", new dice(3));
    }

    public Gauntlet(String name){
        this(1,5,"Gauntlet Spiked", new dice(4));
    }

}
