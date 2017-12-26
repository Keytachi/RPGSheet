package com.company.Items.Equipment.Weapon.Martial;

import com.company.Items.Equipment.Weapon.Abstract_Weapon;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Weapon_Category;


public class Abstract_MartialWeapon extends Abstract_Weapon {

    public Abstract_MartialWeapon(int weight, int cost, int damage, String name) {
        super(weight, cost, damage, name);
        this.weaponCategories = Weapon_Category.MARTIAL;
    }
}
