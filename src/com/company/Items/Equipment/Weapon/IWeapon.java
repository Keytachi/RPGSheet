package com.company.Items.Equipment.Weapon;

import com.company.Items.Equipment.IEquipment;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Hand_Req;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Attack_Type;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Weapon_Type;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Properties;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Weapon_Category;

import java.util.List;


public interface IWeapon extends IEquipment {

    int attack();
    Weapon_Category getCategories();
    Attack_Type getAttackType();
    List<Properties> getProperties();
    Weapon_Type getWeaponType();
    Hand_Req getHandReq();
}
