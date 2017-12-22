package com.company.Items.Equipment.Weapon.Simple.SimpleMeleeWeapon;

import com.company.Items.Equipment.Weapon.Attack_Type;
import com.company.Items.Equipment.Weapon.Hand_Req;
import com.company.Items.Equipment.Weapon.Simple.Abstract_SimpleWeapon;
import com.company.Items.Equipment.Weapon.Weapon_Type;

/**
 * Created by ble on 12/22/2017.
 */

public class Club extends Abstract_SimpleWeapon {

    public Club(int weight, int cost, int damage, String name) {
        super(weight, cost, damage, name);
        this.attackType = Attack_Type.BLUDGEONING;
        this.handReq = Hand_Req.ONEHAND;
        this.weaponType = Weapon_Type.MACE;
    }

    public Club(){
        this(2, 1, 4, "Club");
    }

    public Club(String name){
        this(2, 1, 4,name);
    }


}
