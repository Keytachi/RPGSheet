package com.company.Items.Equipment.Weapon.Simple;

import com.company.Items.Equipment.Weapon.AWeapon;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Weapon_Category;


public abstract class ASimpleWeapon extends AWeapon {

    public ASimpleWeapon(int weight, int cost, int damage, String name) {
        super(weight, cost, damage, name);
        this.weaponCategories = Weapon_Category.SIMPLE;
    }
}
