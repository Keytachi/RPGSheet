package com.company.Equipment.Weapon;

import com.company.Util.dice;

public class Club extends Weapon {

    public Club(int weight, int cost, String name) {
        super(weight, cost, name, Damage_Type.BLUDGEONING, new dice(4));
    }

    public Club(){
        this(2,1,"Club");
    }

    @Override
    public String toString(){
        return "Club";
    }
}
