package com.company.CharacterPanel;

import com.company.Character.PlayerCharacter;
import com.company.Items.Equipment.Armor.Shield;
import com.company.Util.EnumContainer;
import com.company.Util.EnumContainer.GearSlot;
import com.company.Util.Util;

public class Armor extends Stats {

    public Armor() {
        super(10);
    }

    private void setArmor(PlayerCharacter host){
        for(GearSlot weaponSlot : EnumContainer.weapon_Slot){
            if(Util.gearisInstance(host.get_GearEquipment().getWeapon(weaponSlot),Shield.class)){
                increaseBaseValue(baseValue + host.getArmorValue(GearSlot.ARMOR)
                        + host.getArmorValue(weaponSlot));
                break;
            }
            else{
                increaseBaseValue( baseValue +
                        host.getArmorValue(GearSlot.ARMOR));
                break;
            }
        }
    }

    public void update(PlayerCharacter host){
        setArmor(host);
        getFinalValue();
    }

}
