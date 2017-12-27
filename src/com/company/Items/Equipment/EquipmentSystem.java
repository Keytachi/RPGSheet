package com.company.Items.Equipment;

import com.company.Items.Equipment.Armor.Armor;
import com.company.Items.Equipment.Armor.Naked;
import com.company.Items.Equipment.Weapon.Simple.SimpleMeleeWeapon.Unarm;
import com.company.Items.Equipment.Weapon.Weapon;
import com.company.Character.PlayerCharacter;
import com.company.Util.EnumContainer;
import com.company.Util.EnumContainer.GearSlot;

import java.util.HashMap;
import java.util.Map;

public class EquipmentSystem {


    private Map<EnumContainer.GearSlot,Abstract_Equipment> armorEquipment;
    private Map<EnumContainer.GearSlot,Weapon> weaponEquipment;

    public EquipmentSystem(){
        this.armorEquipment = new HashMap<EnumContainer.GearSlot,Abstract_Equipment>(){
            {
                put(GearSlot.ARMOR, new Naked());
            }};
        this.weaponEquipment = new HashMap<EnumContainer.GearSlot,Weapon>(){
            {
                put(GearSlot.LHAND, new Unarm());
                put(GearSlot.RHAND, new Unarm());
            }
        };
    }

    public Map<GearSlot,Abstract_Equipment> getArmorEquipment(){
        return this.armorEquipment;
    }
    public Map<GearSlot,Weapon> getWeaponEquipment() {return this.weaponEquipment;}

    public Abstract_Equipment getArmor(GearSlot gearSlot){
        return this.armorEquipment.get(gearSlot);
    }
    public Weapon getWeapon(GearSlot gearSlot){return this.weaponEquipment.get(gearSlot);}

    public void equip(Weapon weapon, PlayerCharacter character){
        switch(weapon.getHandReq()){
            case ONEHAND:
                equip1H(weapon,character);
                break;
            case TWOHAND:
                equip2H(weapon,character);
                break;
        }
    }

    public void equip(Armor armor, PlayerCharacter character){
        equipArmor(armor,character);
    }

    private void equipArmor(Armor equipment, PlayerCharacter character){
        remove_Gear(armorEquipment, GearSlot.ARMOR, character);
        armorEquipment.put(GearSlot.ARMOR,equipment);
    }

    //TODO: Finish this function.
    private void equip1H(Weapon equipment, PlayerCharacter character){
        switch(equipment.getWeaponType()){
            case SHIELD:
                remove_Gear(weaponEquipment, GearSlot.LHAND, character);
                weaponEquipment.put(GearSlot.LHAND, equipment);
                break;
        }


    }

    private void equip2H(Weapon equipment, PlayerCharacter character){
        for(GearSlot hands : EnumContainer.weapon_Slot){
            remove_Gear(weaponEquipment, hands, character);
            weaponEquipment.put(hands, equipment);
        }
    }

    public void remove_Gear(Map equipmentSlot, GearSlot location, PlayerCharacter character){
        if(equipmentSlot.get(location) instanceof Armor) {
            if (!(equipmentSlot.get(location) instanceof Naked)) {
                character.get_InventoryBag().storeItem((Item) equipmentSlot.get(location));
            }
        }else if(!(equipmentSlot.get(location) instanceof Unarm)){
            character.get_InventoryBag().storeItem((Item) equipmentSlot.get(location));
        }
    }
}
