package com.company.Equipment.Weapon.SmipleWeapons.OneHandedMelee;

import com.company.Util.dice;

public class MaceH extends SimpleOneHand {

    public MaceH(int weight, int cost, String name) {
        super(weight, cost, name, Damage_Type.BLUDGEONING, new dice (8));
    }

    public MaceH(){
        this(8,12,"Mace (Heavy)");
    }
}
