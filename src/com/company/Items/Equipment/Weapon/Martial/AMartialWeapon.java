package com.company.Items.Equipment.Weapon.Martial;

import com.company.Items.Equipment.Weapon.AWeapon;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Weapon_Category;


public class AMartialWeapon extends AWeapon {

    public AMartialWeapon(int weight, int cost, int damage, String name) {
        super(weight, cost, damage, name);
        this.weaponCategories = Weapon_Category.MARTIAL;
    }
}
