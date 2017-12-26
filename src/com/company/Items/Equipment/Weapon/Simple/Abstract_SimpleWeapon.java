package com.company.Items.Equipment.Weapon.Simple;

import com.company.Items.Equipment.Weapon.Abstract_Weapon;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Weapon_Category;

import java.util.List;


public abstract class Abstract_SimpleWeapon extends Abstract_Weapon {

    public Abstract_SimpleWeapon(int weight, int cost, int damage, String name) {
        super(weight, cost, damage, name);
        this.weaponCategories = Weapon_Category.SIMPLE;
    }
}
