package com.company;

import com.company.Equipment.Armor.Armor;
import com.company.Equipment.Armor.Naked;
import com.company.Equipment.Armor.Shield;
import com.company.Equipment.Equipment;
import com.company.Equipment.Weapon.SmipleWeapons.TwoHandedMelee.SimpleTwoHand;
import com.company.Equipment.Weapon.SmipleWeapons.UnarmWeapon.Unarm;
import com.company.Equipment.Weapon.Weapon;
import com.company.Util.EnumContainer;
import com.company.Util.EnumContainer.GearSlot;
import com.company.Util.Util;

import java.util.HashMap;
import java.util.Map;

public class EquipmentSystem {

    private Map<EnumContainer.GearSlot,Equipment> gearEquipment;

    public EquipmentSystem(){
        this.gearEquipment = new HashMap<EnumContainer.GearSlot,Equipment>(){
            {
                put(GearSlot.ARMOR, new Naked());
                put(GearSlot.LHAND, new Unarm());
                put(GearSlot.RHAND, new Unarm());
            }};
    }

    public Map<GearSlot,Equipment> getGearEquipment(){
        return this.gearEquipment;
    }

    private Boolean isGearEquip(GearSlot slot){
        if(slot == GearSlot.RHAND || slot == GearSlot.LHAND){
                return gearEquipment.get(slot) instanceof Unarm;
        }else{
                return gearEquipment.get(slot) instanceof Naked;
        }
    }

    public void equip(PlayerCharacter person,Equipment gear, GearSlot slot){
        if(slot == GearSlot.RHAND || slot == GearSlot.LHAND){
            equipWeaponSlot(person,slot,gear);
        }else{
            equipArmorSlot(person,slot, (Armor)gear);
        }
    }

    private void equipWeaponSlot(PlayerCharacter person,GearSlot weaponSlot,Equipment gear){
        if(Util.gearisInstance(gear, SimpleTwoHand.class)) {
            for (GearSlot slot : EnumContainer.weapon_Slot) {
                if (!isGearEquip(slot)) {
                    if (gearEquipment.get(GearSlot.RHAND) == gearEquipment.get(GearSlot.LHAND)) {
                        person.getInventoryBag().storeItem(person, gearEquipment.get(slot));
                        break;
                    } else {
                        person.getInventoryBag().storeItem(person, gearEquipment.get(slot));
                    }
                }
                gearEquipment.put(slot, gear);
            }
        }else {
            if (!isGearEquip(weaponSlot)){
                person.getInventoryBag().storeItem(person,gearEquipment.get(weaponSlot));
                if(gearEquipment.get(GearSlot.RHAND) == gearEquipment.get(GearSlot.LHAND)) {
                    for (GearSlot slot : EnumContainer.weapon_Slot){
                        replaceGearEmpty(slot);
                    }
                }
            }
            gearEquipment.put(weaponSlot, gear);
        }
    }

    private void equipArmorSlot(PlayerCharacter person,GearSlot armorSlot,Armor gear){
        if(!isGearEquip(armorSlot)) {
            {
                person.getInventoryBag().storeItem(person,gear);
            }
            gearEquipment.put(armorSlot, gear);
        }
    }

    private void replaceGearEmpty(GearSlot slot){
        if(slot == GearSlot.RHAND || slot == GearSlot.LHAND){
            gearEquipment.put(slot, new Unarm());
        }else{
            gearEquipment.put(slot, new Naked());
        }
    }
}
