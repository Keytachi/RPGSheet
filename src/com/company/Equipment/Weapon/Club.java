package com.company.Equipment.Weapon;

import com.company.Util.dice;

public class Club extends Weapon {

    public Club(int weight, int cost, String name, Damage_Type type, dice damage_Die) {
        super(weight, cost, name, type, damage_Die);
    }

    public Club(){
        super(2,1,"Club",Damage_Type.BLUDGEONING,new dice(4));
    }

    @Override
    public String toString(){
        return "Club";
    }
}
