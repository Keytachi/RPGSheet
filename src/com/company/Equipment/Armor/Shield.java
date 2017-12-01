package com.company.Equipment.Armor;

import com.company.Equipment.Weapon.SmipleWeapons.OneHandedMelee.Club;
import com.company.Equipment.Weapon.Weapon;

public class Shield extends Armor {

    private Weapon damageDealer;
    public Shield(String name, int cost, int weight, int armor, Weapon damageDealer) {
        super(name, cost, weight, armor);
        this.armor = armor;
        this.damageDealer = damageDealer;

    }

    public Shield(){
        this("Shield",10,6,2,
        new Club(6,10,"Shield"));
    }

    public Weapon getDamageDealer(){
        return damageDealer;
    }
}
