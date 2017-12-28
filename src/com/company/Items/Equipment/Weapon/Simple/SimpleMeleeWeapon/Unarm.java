package com.company.Items.Equipment.Weapon.Simple.SimpleMeleeWeapon;

import com.company.Items.Equipment.Weapon.Simple.ASimpleWeapon;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Hand_Req;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Attack_Type;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Weapon_Type;

/**
 * Created by ble on 12/26/2017.
 */
public class Unarm extends ASimpleWeapon {

    public Unarm(int weight, int cost, int damage, String name) {
        super(weight, cost, damage, name);
        this.attackType = Attack_Type.BLUDGEONING;
        this.handReq = Hand_Req.ONEHAND;
        this.weaponType = Weapon_Type.FIST;
    }

    public Unarm(){
        this(0,0,1, "Unarm Strike");
    }
}
