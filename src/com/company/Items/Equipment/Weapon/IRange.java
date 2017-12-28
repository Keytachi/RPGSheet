package com.company.Items.Equipment.Weapon;

import com.company.Character.PlayerCharacter;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Amunition_Type;

/**
 * Created by ble on 12/26/2017.
 */

public interface IRange {


    int get_Distance();
    //TODO: Get the location of player when grid has been implemented.
    int in_Range(PlayerCharacter target);
    Amunition_Type get_Amunition_Type();

}
