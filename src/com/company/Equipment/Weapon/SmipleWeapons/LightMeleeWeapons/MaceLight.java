package com.company.Equipment.Weapon.SmipleWeapons.LightMeleeWeapons;

import com.company.Util.dice;

public class MaceLight extends SimpleLight {

    public MaceLight(int weight, int cost, String name) {
        super(weight, cost, name, Damage_Type.BLUDGEONING, new dice(4));
    }

    public MaceLight(){
        this(4,5,"Mace (Light)");
    }
}