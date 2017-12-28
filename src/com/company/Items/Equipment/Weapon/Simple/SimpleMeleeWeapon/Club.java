package com.company.Items.Equipment.Weapon.Simple.SimpleMeleeWeapon;

import com.company.Items.Equipment.Weapon.Simple.ASimpleWeapon;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Properties;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Hand_Req;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Attack_Type;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Weapon_Type;


/**
 * Created by ble on 12/22/2017.
 */

public class Club extends ASimpleWeapon {

    public Club(int weight, int cost, int damage, String name) {
        super(weight, cost, damage, name);
        this.attackType = Attack_Type.BLUDGEONING;
        this.handReq = Hand_Req.ONEHAND;
        this.weaponType = Weapon_Type.MACE;
        addSpecialty();
    }

    public Club(){
        this(2, 1, 4, "Club");
    }

    public Club(String name){
        this(2, 1, 4,name);
    }

    public void addSpecialty(){
        this.specialty.add(Properties.LIGHT);
    }
}
