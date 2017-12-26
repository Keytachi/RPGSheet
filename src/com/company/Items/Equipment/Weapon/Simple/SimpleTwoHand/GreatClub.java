package com.company.Items.Equipment.Weapon.Simple.SimpleTwoHand;

import com.company.Items.Equipment.Weapon.Simple.Abstract_SimpleWeapon;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Hand_Req;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Attack_Type;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Weapon_Type;
import com.company.Items.Equipment.Weapon.Weapon_Enum.Properties;
/**
 * Created by ble on 12/26/2017.
 */

public class GreatClub extends Abstract_SimpleWeapon {

    public GreatClub(int weight, int cost, int damage, String name) {
        super(weight, cost, damage, name);
        this.attackType = Attack_Type.BLUDGEONING;
        this.handReq = Hand_Req.TWOHAND;
        this.weaponType = Weapon_Type.MACE;
    }

    public GreatClub(){
        this(10, 2, 8, "Great Club");
    }
}
