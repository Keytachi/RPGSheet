package com.company.CharacterPanel;

import com.company.Character.PlayerCharacter;
import com.company.Items.Equipment.Armor.IArmor;
import com.company.Items.Equipment.Armor.Shield;
import com.company.Util.EnumContainer;
import com.company.Util.EnumContainer.GearSlot;
import com.company.Util.Util;

public class Armor extends Stats {

    public static final int BASE_ARMOR = 10;
    public Armor() {
        super(BASE_ARMOR);
    }

    private void setArmor(PlayerCharacter host){
        outerloop:
        for(GearSlot weaponSlot : EnumContainer.weapon_Slot){
            if(Util.gearisInstance(host.get_GearEquipment().getWeapon(weaponSlot),Shield.class)) {
                baseValue = BASE_ARMOR + host.getArmorValue(host.get_GearEquipment().getArmor(GearSlot.ARMOR))
                        + host.getArmorValue((IArmor)host.get_GearEquipment().getWeapon(weaponSlot));
                break outerloop;
            }
            baseValue =  BASE_ARMOR +
                    host.getArmorValue(host.get_GearEquipment().getArmor(GearSlot.ARMOR));
        }
    }

    public void update(PlayerCharacter host){
        setArmor(host);
        getFinalValue();
    }

}
