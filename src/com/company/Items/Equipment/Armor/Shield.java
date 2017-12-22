package com.company.Items.Equipment.Armor;

import com.company.Items.Equipment.Weapon.Attack_Type;
import com.company.Items.Equipment.Weapon.Hand_Req;
import com.company.Items.Equipment.Weapon.Weapon;
import com.company.Items.Equipment.Weapon.Weapon_Categories;
import com.company.Items.Equipment.Weapon.Weapon_Type;

public class Shield extends Abstract_Armor implements Weapon {

    public Shield(String name, int cost, int weight, int armor) {
        super(armor, cost, weight, name);

    }

    public Shield(){
        this("Shield",10,6,2);
    }

    @Override
    public int attack() {
        return (int)(Math.random()*6)+1;
    }

    @Override
    public Weapon_Categories getCategories() {
        return Weapon_Categories.MARTIAL;
    }

    @Override
    public Attack_Type getAttackType() {
        return Attack_Type.BLUDGEONING;
    }

    @Override
    public Weapon_Type getWeaponType() {
        return Weapon_Type.SHIELD;
    }

    @Override
    public Hand_Req getHandReq() {
        return Hand_Req.ONEHAND;
    }
}
