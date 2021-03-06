package com.company.Character;

import com.company.Items.Equipment.Armor.IArmor;
import com.company.Items.Equipment.Armor.Naked;
import com.company.Items.Equipment.Armor.Shield;
import com.company.Items.Equipment.IEquipment;
import com.company.Items.Equipment.Item;
import com.company.Items.Equipment.Weapon.Simple.SimpleMeleeWeapon.Unarm;
import com.company.Items.Equipment.Weapon.IWeapon;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer;
import com.company.Util.EnumContainer;
import com.company.Util.EnumContainer.GearSlot;
import com.company.Util.Util;

import java.util.HashMap;
import java.util.Map;

public class EquipmentSystem {

    //TODO: Check to see if the Two-Handed Weapon is be place twice in a bag!

    private Map<EnumContainer.GearSlot,IArmor> armorEquipment;
    private Map<EnumContainer.GearSlot,IWeapon> weaponEquipment;

    public EquipmentSystem(){
        this.armorEquipment = new HashMap<EnumContainer.GearSlot,IArmor>(){
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

    public Map<GearSlot,IArmor> getArmorEquipment(){
        return this.armorEquipment;
    }
    public Map<GearSlot,IWeapon> getWeaponEquipment() {return this.weaponEquipment;}

    public IArmor getArmor(GearSlot gearSlot){
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

    public void equip(IArmor IArmor, PlayerCharacter character){
        equipArmor(IArmor,character);
    }


    public void equip(IWeapon weapon, GearSlot hand, PlayerCharacter character)throws NotCorrectSlotException {

        if(!EnumContainer.weapon_Slot.contains(hand)){
                throw new NotCorrectSlotException(weapon,hand);
        }
        switch (weapon.getHandReq()){
            /**
             * Two Hand weapon will be place in the automation equip for two hand since it will always replace both
             * weapons and equipped the weapon in both hand.
             */
            case TWOHAND:
                equip2H(weapon, character);
                break;
            default:
                if(weaponEquipment.get(GearSlot.LHAND).getHandReq().equals(Weapon_EnumContainer.Hand_Req.TWOHAND)){
                    remove_Gear(weaponEquipment,GearSlot.RHAND,character);
                    remove_2H();
                }else {
                    remove_Gear(weaponEquipment, hand, character);
                }
                weaponEquipment.put(hand, weapon);

        }
    }

    private void equipArmor(IArmor equipment, PlayerCharacter character){
        remove_Gear(armorEquipment, GearSlot.ARMOR, character);
        armorEquipment.put(GearSlot.ARMOR,equipment);
    }

    private void equip1H(IWeapon equipment, PlayerCharacter character){
        /**
         * Removing atleast from one hand to store into inventory and then un-equip from both hands.
         */
        if(weaponEquipment.get(GearSlot.LHAND).getHandReq().equals(Weapon_EnumContainer.Hand_Req.TWOHAND)){
            remove_Gear(weaponEquipment,GearSlot.RHAND,character);
            remove_2H();
        }
        switch(equipment.getWeaponType()){

            /**
             * Function is to use to equip Shield for the player.
             * If there is another Shield, then it will replace that Shield. Shield is only limited to One slot.
             * Else it will equip the Shield to the Left Hand as default.
             */
            case SHIELD:
                for (GearSlot hand : EnumContainer.weapon_Slot){
                    if(weaponEquipment.get(hand) instanceof Shield){
                        remove_Gear(weaponEquipment,hand,character);
                        weaponEquipment.put(hand,equipment);
                        break;
                    }
                }
                remove_Gear(weaponEquipment, GearSlot.LHAND, character);
                weaponEquipment.put(GearSlot.LHAND, equipment);
                break;

            /**
             * Function is for using to auto equip.
             * Not the best to use unless player wants to do a quick equip. Since it will only look for either an empty
             * hand or not in the proficiency list of the class.
             * If player has a Shield equipped, it will look for the next hand since it is going to assume the player
             * want the shield over dual wielding.
             * **NOT INTENDED TO USE TOO OFTEN!**
             */
            default:
                outerloop:
                for(GearSlot hand : EnumContainer.weapon_Slot){
                    for(Class weapon_Proficiency : character.get_CRole().getWeaponProficiencyList()) {
                        if (!(Util.gearisInstance(hand, weapon_Proficiency))) {
                            if (!(weaponEquipment.get(hand) instanceof Shield)) {
                                remove_Gear(weaponEquipment, hand, character);
                                weaponEquipment.put(hand, equipment);
                                break outerloop;
                            }
                        }
                    }
                    if(weaponEquipment.get(hand) instanceof Unarm){
                        weaponEquipment.put(hand,equipment);
                        break;
                    }
                }
        }
    }

    private void equip2H(IWeapon equipment, PlayerCharacter character){
        if(weaponEquipment.get(GearSlot.LHAND).getHandReq().equals(Weapon_EnumContainer.Hand_Req.TWOHAND)){
            remove_Gear(weaponEquipment,GearSlot.RHAND,character);
            remove_2H();
        }

        EnumContainer.weapon_Slot.forEach(hand -> {
            remove_Gear(weaponEquipment, hand, character);
            weaponEquipment.put(hand,equipment);
        });

        /**for(GearSlot hands : EnumContainer.weapon_Slot){
            remove_Gear(weaponEquipment, hands, character);
            weaponEquipment.put(hands, equipment);
        }*/
    }

    public void remove_2H(){
        EnumContainer.weapon_Slot.forEach(hand -> weaponEquipment.put(hand,new Unarm()));
    }


    public void remove_Gear(Map equipmentSlot, GearSlot location, PlayerCharacter character){
        if(equipmentSlot.get(location) instanceof IArmor) {
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
