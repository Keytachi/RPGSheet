package com.company.CharacterPanel;

import com.company.Character.PlayerCharacter;
import com.company.Items.Equipment.Armor.IArmor;
import com.company.Items.Equipment.Armor.Shield;
import com.company.Util.EnumContainer;
import com.company.Util.Util;

public class Armor extends CharacterInformation {

    public Armor() {
        super(10);
    }

    private void setArmor(PlayerCharacter character){
        for(Enum weaponSlot : EnumContainer.weapon_Slot){
            if(Util.gearisInstance(character.getGear_Equipment().getWeaponEquipment().get(weaponSlot),Shield.class)){
                increaseBaseValue(baseValue +
                        ((IArmor) character.getGear_Equipment().getArmor(EnumContainer.GearSlot.ARMOR)).get_Armor(character)
                        + ((IArmor) character.getGear_Equipment().getWeaponEquipment().get(weaponSlot)).get_Armor(character));
                break;
            }
            else{
                increaseBaseValue( baseValue +
                        ((IArmor) character.getGear_Equipment().getArmor(EnumContainer.GearSlot.ARMOR)).get_Armor(character));
                break;
            }
        }
    }

    public void update(PlayerCharacter character){
        setArmor(character);
        getFinalValue();
    }

}
