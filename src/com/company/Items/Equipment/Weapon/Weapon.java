package com.company.Items.Equipment.Weapon;

import com.company.Items.Equipment.Abstract_Equipment;


public interface Weapon extends Abstract_Equipment {

    int attack();
    Weapon_Categories getCategories();
    Attack_Type getAttackType();
    Weapon_Type getWeaponType();
    Hand_Req getHandReq();
}
