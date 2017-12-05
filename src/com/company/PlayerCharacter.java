package com.company;

import com.company.ClassType.*;
import com.company.Equipment.Armor.Armor;
import com.company.Equipment.Armor.Heavy_Armor.HeavyArmor;
import com.company.Equipment.Armor.Light_Armor.LightArmor;
import com.company.Equipment.Armor.Medium_Armor.MediumArmor;
import com.company.Equipment.*;
import com.company.Equipment.Armor.Naked;
import com.company.Equipment.Armor.Shield;
import com.company.Equipment.Weapon.*;
import com.company.Equipment.Weapon.SmipleWeapons.UnarmWeapon.Unarm;
import com.company.RaceType.Race;
import com.company.Util.EnumContainer;
import com.company.Util.Util;

import java.util.HashMap;
import java.util.Map;

public class PlayerCharacter {

    private Race race;
    private ClassRole role;
    private Bag inventoryBag;

    private int current_Health;
    private int maximum_Health;
    private int armor_Amount;

    private static final int BASE_ARMOR = 10;


    private Map<EnumContainer.GearSlot,Equipment> gearEquipment = new HashMap<EnumContainer.GearSlot,Equipment>(){
        {
            put(EnumContainer.GearSlot.ARMOR, new Naked());
            put(EnumContainer.GearSlot.LHAND, new Unarm());
            put(EnumContainer.GearSlot.RHAND, new Unarm());
        }};

    public PlayerCharacter(Race race, ClassRole role, Bag inventoryBag){
        this.race = race;
        this.role = role;
        this.inventoryBag = inventoryBag;
        updatePlayer();

    }



    //Composition of other classes that are being built in this class.
    public Race getRace() {
        return race;
    }
    public ClassRole getRole() {
        return role;
    }

    public Bag getInventoryBag(){
        return inventoryBag;
    }

    public Map<EnumContainer.GearSlot, Equipment> getGearEquipment() {
        return gearEquipment;
    }


    /**
     * Work on this when creating more classes.
     * THIS IS ONLY INTENDED FOR INSTANTIATING THE CHARACTER!
     */
    public void setHealth(){
        if (role instanceof Barbarian){
            setMaximum_Health(12 + race.getCons_Modifier());
            setCurrent_Health(maximum_Health);
        }
        else if (role instanceof Mage){
            setMaximum_Health(8 + race.getCons_Modifier());
            setCurrent_Health(maximum_Health);
        }
    }

    public void setCurrent_Health(int current_Health) {
        this.current_Health = current_Health;
        if(this.current_Health > this.maximum_Health){
            this.current_Health = this.maximum_Health;
        }
    }

    public void setMaximum_Health(int maximum_Health) {
        this.maximum_Health = maximum_Health;
    }

    public int getCurrent_Health() {
        return current_Health;
    }

    public int getMaximum_Health() {
        return maximum_Health;
    }

    public int getMax_BagWeight(){
        return race.getStrength() * 15;
    }

    public int getArmor_Amount(){
        return armor_Amount;
    }

    private void setArmor_Amount(){
        for(Enum weaponSlot : EnumContainer.weapon_Slot){
            if(Util.gearisInstance(gearEquipment.get(weaponSlot),Shield.class)){
                armor_Amount = BASE_ARMOR +
                        ((Armor)gearEquipment.get(EnumContainer.GearSlot.ARMOR)).get_Armor(this) +
                        ((Armor)gearEquipment.get(weaponSlot)).get_Armor(this) ;
            }
        }
        armor_Amount = BASE_ARMOR +
                ((Armor)gearEquipment.get(EnumContainer.GearSlot.ARMOR)).get_Armor(this);
    }


    /**TODO: Below statement.
     * Rework this function.
     * Idea: Check if the gear is an Armor or Weapon.
     * If Armor:
     *          Check to see if it is a shield.
     *          If it is a shield:
     *              Equip the shield onto the Weapon_Slot.
     *          If it is not a shield:
     *              Equip the armor onto the Body.
     *
     * If Weapon:
     *          Check to see if it is a 2 Hand Weapon (Simple or Martial):
     *          If it is not a 2 Hand Weapon:
     *              Check to see if there is a slot empty.
     *              If there are no slot empty:
     *                  Unequip the selected Weapon_Slot.
     *                  Equip the gear to the Weapon_Slot.
     *              else:
     *                  Equip the gear to the Weapon_Slot.
     *          else:
     *              Check to see if both slot are empty.
     *              If they are both empty:
     *                  Equip the 2 Hand Weapon to both Weapon_Slot (Clone?)
     *              else:
     *                  Unequip any weapon from Weapon_Slots.
     *                  Equip the 2 Hand Weapon to both Weapon_Slot (Clone?)
     *
     * Update Character to see if the armor has been set differently.
     */
    public void equipGear(EnumContainer.GearSlot gearSlot, Equipment gear) {

        if (Util.gearisInstance(gear, Armor.class))
        {
            if (gearSlot == EnumContainer.GearSlot.ARMOR) {
                gearEquipment.put(gearSlot, gear);
            }
        }
        else if (Util.gearisInstance(gear, Weapon.class) || Util.gearisInstance(gear,Shield.class)){
            if (gearSlot == EnumContainer.GearSlot.LHAND || gearSlot == EnumContainer.GearSlot.RHAND) {
                if (gearEquipment.get(gearSlot) instanceof Unarm == false) {
                    unEquipGear(gearSlot);
                }
                gearEquipment.put(gearSlot,gear);
            }
        }
    }

    public void unEquipGear(EnumContainer.GearSlot gearSlot){
        if(gearSlot == EnumContainer.GearSlot.ARMOR){
            gearEquipment.put(gearSlot,new Naked());
        }
        else if (gearSlot == EnumContainer.GearSlot.LHAND || gearSlot == EnumContainer.GearSlot.RHAND){
            gearEquipment.put(gearSlot,new Unarm());
        }
    }

    public void updatePlayer(){
        setHealth();
        setArmor_Amount();
    }
}
