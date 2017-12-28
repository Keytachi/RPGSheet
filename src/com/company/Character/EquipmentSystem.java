package com.company.Character;

import com.company.Items.Equipment.Armor.Armor;
import com.company.Items.Equipment.Armor.Naked;
import com.company.Items.Equipment.Armor.Shield;
import com.company.Items.Equipment.IEquipment;
import com.company.Items.Equipment.Item;
import com.company.Items.Equipment.Weapon.Simple.SimpleMeleeWeapon.Unarm;
import com.company.Items.Equipment.Weapon.IWeapon;
import com.company.Util.EnumContainer;
import com.company.Util.EnumContainer.GearSlot;
import com.company.Util.Util;

import java.util.HashMap;
import java.util.Map;

public class EquipmentSystem {


    private Map<EnumContainer.GearSlot,IEquipment> armorEquipment;
    private Map<EnumContainer.GearSlot,IWeapon> weaponEquipment;

    public EquipmentSystem(){
        this.armorEquipment = new HashMap<EnumContainer.GearSlot,IEquipment>(){
            {
                put(GearSlot.ARMOR, new Naked());
            }};
        this.weaponEquipment = new HashMap<EnumContainer.GearSlot,IWeapon>(){
            {
                put(GearSlot.LHAND, new Unarm());
                put(GearSlot.RHAND, new Unarm());
            }
        };
    }

    public Map<GearSlot,IEquipment> getArmorEquipment(){
        return this.armorEquipment;
    }
    public Map<GearSlot,IWeapon> getWeaponEquipment() {return this.weaponEquipment;}

    public IEquipment getArmor(GearSlot gearSlot){
        return this.armorEquipment.get(gearSlot);
    }
    public IWeapon getWeapon(GearSlot gearSlot){return this.weaponEquipment.get(gearSlot);}

    public void equip(IWeapon weapon, PlayerCharacter character){
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

    //TODO: Figure out why it is throwing exception when it is the correct slot.
    public void equip(IWeapon weapon, GearSlot hand, PlayerCharacter character)throws NotCorrectSlotException {

        System.out.println(hand.equals(GearSlot.RHAND));
        if(!(hand.equals(GearSlot.RHAND)) || !(hand.equals(GearSlot.LHAND))) {
            throw new NotCorrectSlotException(weapon, hand);
        }

        switch (weapon.getHandReq()){
            case TWOHAND:
                equip2H(weapon, character);
                break;
            default:
                remove_Gear(weaponEquipment,hand,character);
                weaponEquipment.put(hand, weapon);

        }
    }

    private void equipArmor(Armor equipment, PlayerCharacter character){
        remove_Gear(armorEquipment, GearSlot.ARMOR, character);
        armorEquipment.put(GearSlot.ARMOR,equipment);
    }

    //TODO: Finish this function.
    private void equip1H(IWeapon equipment, PlayerCharacter character){
        switch(equipment.getWeaponType()){
            case SHIELD:
                //Characters should never have two shield equipped.
                for (GearSlot hand : EnumContainer.weapon_Slot){
                    if(weaponEquipment.get(hand) instanceof Shield){
                        remove_Gear(weaponEquipment,hand,character);
                        weaponEquipment.put(hand,equipment);
                        break;
                    }
                }
                //If Character does not have a Shield then it directly goes to the Left Hand.
                remove_Gear(weaponEquipment, GearSlot.LHAND, character);
                weaponEquipment.put(GearSlot.LHAND, equipment);
                break;
            default:
                for(GearSlot hand : EnumContainer.weapon_Slot){
                    for(Class weapon_Proficiency : character.get_Role().getWeaponProficiencyList()){
                        if(!(Util.gearisInstance(hand,weapon_Proficiency))){
                            remove_Gear(weaponEquipment, hand, character);
                            weaponEquipment.put(hand, equipment);
                            break;
                        }
                    }
                }
        }
    }

    private void equip2H(IWeapon equipment, PlayerCharacter character){
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

class NotCorrectSlotException extends Exception{

    private GearSlot slot;
    private IEquipment equipment;
    public NotCorrectSlotException(IEquipment equipment, GearSlot slot){
        this.slot = slot;
        this.equipment = equipment;
    }

    public GearSlot getSlot() {
        return slot;
    }

    public IEquipment getEquipment() {
        return equipment;
    }
}
