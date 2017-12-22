package com.company.Items.Equipment.Weapon.Simple;

import com.company.Items.Equipment.Weapon.Abstract_Weapon;
import com.company.Items.Equipment.Weapon.Attack_Type;
import com.company.Items.Equipment.Weapon.Hand_Req;
import com.company.Items.Equipment.Weapon.Weapon_Categories;
import com.company.Items.Equipment.Weapon.Weapon_Type;
import com.company.Util.dice;

/**
 * Created by ble on 12/22/2017.
 */

public abstract class Abstract_SimpleWeapon extends Abstract_Weapon {

    public Abstract_SimpleWeapon(int weight, int cost, int damage, String name) {
        super(weight, cost, damage, name);
        this.weaponCategories = Weapon_Categories.SIMPLE;
    }
}
