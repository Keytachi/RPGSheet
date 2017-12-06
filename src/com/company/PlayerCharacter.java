package com.company;

import com.company.ClassType.*;
import com.company.Equipment.Armor.Armor;
import com.company.Equipment.*;
import com.company.Equipment.Armor.Naked;
import com.company.Equipment.Armor.Shield;
import com.company.Equipment.Weapon.*;
import com.company.Equipment.Weapon.SmipleWeapons.TwoHandedMelee.SimpleTwoHand;
import com.company.Equipment.Weapon.SmipleWeapons.UnarmWeapon.Unarm;
import com.company.RaceType.Race;
import com.company.Util.EnumContainer;
import com.company.Util.EnumContainer.GearSlot;
import com.company.Util.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        setHealth();
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
    private void setHealth(){
        if (role instanceof Barbarian){
            setMaximum_Health(12 + race.getCons_Modifier());
            setCurrent_Health(maximum_Health);
        }
        else if (role instanceof Wizard){
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
                this.armor_Amount = BASE_ARMOR +
                        ((Armor)gearEquipment.get(GearSlot.ARMOR)).get_Armor(this) +
                        ((Armor)gearEquipment.get(weaponSlot)).get_Armor() ;
                break;
            }
            else{
                this.armor_Amount = BASE_ARMOR +
                        ((Armor)gearEquipment.get(GearSlot.ARMOR)).get_Armor(this);
            }
        }
    }

    public void setArmor_Amount(int armor_Amount){
        this.armor_Amount = armor_Amount;
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
    public void equipGear(GearSlot gearSlot, Equipment gear) {

        if(Util.gearisInstance(gear,Armor.class)){
            if(Util.gearisInstance(gear,Shield.class)){
                equipShield(gearSlot,(Shield)gear);
            }
            else{
                eqiupArmor(gearSlot,(Armor)gear);
            }
        }
        else if (Util.gearisInstance(gear,Weapon.class)){
            if(!Util.gearisInstance(gear, SimpleTwoHand.class)){
                equipOneHander(gearSlot, (Weapon)gear);
            }else{
                equipTwoHander((Weapon)gear);
            }
        }
        updatePlayer();
    }

    private void equipShield(GearSlot gearSlot, Shield gear){
        if(gearEquipment.get(gearSlot) instanceof Unarm == false) {
            if (checkTwoHandEquip()) {
                unequipTwoHand();
                gearEquipment.put(gearSlot, gear);
            } else {
                unEquipGear(gearSlot);
                gearEquipment.put(gearSlot, gear);
            }
        }
        else{
            gearEquipment.put(gearSlot,gear);
        }
    }

    private void eqiupArmor(GearSlot gearSlot, Armor gear){
        if(gearEquipment.get(gearSlot) instanceof Naked == false){
            unEquipGear(gearSlot);
            gearEquipment.put(gearSlot,gear);
        }
        else{
            gearEquipment.put(gearSlot,gear);
        }
    }

    private void equipTwoHander(Weapon gear){
        for(Enum<GearSlot> weaponSlot : EnumContainer.weapon_Slot){
            if(gearEquipment.get(weaponSlot) instanceof Unarm == false){
                unEquipGear((EnumContainer.GearSlot)weaponSlot);
                gearEquipment.put((EnumContainer.GearSlot)weaponSlot,gear);
            }
            else{
                gearEquipment.put((EnumContainer.GearSlot)weaponSlot,gear);
            }
        }
    }

    private void equipOneHander(GearSlot gearSlot, Weapon gear){
        if(gearEquipment.get(gearSlot) instanceof Unarm == false) {
            if(checkTwoHandEquip()){
                unequipTwoHand();
                gearEquipment.put(gearSlot,gear);
            }else {
                unEquipGear(gearSlot);
                gearEquipment.put(gearSlot, gear);
            }
        }
        else{
            gearEquipment.put(gearSlot,gear);
        }
    }

    private Boolean checkTwoHandEquip(){
        return gearEquipment.get(GearSlot.LHAND) == gearEquipment.get(GearSlot.RHAND);
    }

    private void unequipTwoHand() {
        for (Enum<GearSlot> weaponSlot : EnumContainer.weapon_Slot) {
            unEquipGear((EnumContainer.GearSlot) weaponSlot);
        }
    }

    public void displayGear(){
        Set<EnumContainer.GearSlot> slots = gearEquipment.keySet();

        for(GearSlot equipment_Slot: slots){
            System.out.println(equipment_Slot + " : " + gearEquipment.get(equipment_Slot));
        }
    }

    public void unEquipGear(GearSlot gearSlot){
        getInventoryBag().storeItem(this,gearEquipment.get(gearSlot));
        if(gearSlot == GearSlot.ARMOR){
            gearEquipment.put(gearSlot,new Naked());
        }
        else if (gearSlot == GearSlot.LHAND || gearSlot == GearSlot.RHAND){
            gearEquipment.put(gearSlot,new Unarm());
        }
    }

    public void updatePlayer(){
        setArmor_Amount();
        if(role instanceof Barbarian){
            ((Barbarian)role).unArmored_Defense(this);
        }
    }
}
