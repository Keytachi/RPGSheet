package com.company.Items.Equipment.Weapon;

import com.company.Items.Equipment.Abstract_Equipment;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Hand_Req;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Attack_Type;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Weapon_Type;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Properties;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Weapon_Category;

import java.util.List;


public interface Weapon extends Abstract_Equipment {

    int attack();
    Weapon_Category getCategories();
    Attack_Type getAttackType();
    List<Properties> getProperties();
    Weapon_Type getWeaponType();
    Hand_Req getHandReq();
}
