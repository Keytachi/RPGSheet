package com.company.Items.Equipment.Armor;

import com.company.Items.Equipment.Weapon.Weapon;
import com.company.Items.Equipment.Weapon.Weapon_Enum;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Hand_Req;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Attack_Type;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Weapon_Type;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Weapon_Category;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Properties;

import java.util.List;

public class Shield extends Abstract_Armor implements Weapon {

    private List<Properties> specialty;
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
    public Weapon_Category getCategories() {
        return Weapon_Category.MARTIAL;
    }
    @Override
    public Weapon_Enum.Attack_Type getAttackType() {
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

    @Override
    public List<Weapon_Enum.Properties> getProperties(){
        return specialty;
    }

}
