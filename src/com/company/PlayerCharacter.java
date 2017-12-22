package com.company;

import com.company.ClassType.*;
import com.company.Items.Equipment.Armor.Armor;
import com.company.Items.Equipment.*;
import com.company.Items.Equipment.Armor.Shield;
import com.company.Items.Equipment.Weapon.Weapon;
import com.company.RaceType.Race;
import com.company.Util.EnumContainer;
import com.company.Util.EnumContainer.GearSlot;
import com.company.Util.Util;

import java.util.Set;

public class PlayerCharacter {

    private Race race;
    private ClassRole role;
    private Bag inventoryBag;
    private EquipmentSystem gear_Equipment;

    private int current_Health;
    private int maximum_Health;
    private int armor_Amount;

    private static final int BASE_ARMOR = 10;


    public PlayerCharacter(Race race, ClassRole role, Bag inventoryBag){
        this.race = race;
        this.role = role;
        this.gear_Equipment = new EquipmentSystem();
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

    public EquipmentSystem getGear_Equipment() {
        return gear_Equipment;
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

    }

    public void setArmor_Amount(int armor_Amount){
        this.armor_Amount = armor_Amount;
    }


    public void displayGear(){

    }


    public void updatePlayer(){
        setArmor_Amount();
        if(role instanceof Barbarian){
            ((Barbarian)role).unArmored_Defense(this);
        }
    }

    public void equip(Abstract_Equipment equipment){
        //gear_Equipment.equip(equipment);
        if(equipment instanceof Weapon){
            gear_Equipment.equip((Weapon)equipment);
        }
        else if(equipment instanceof Armor){
            gear_Equipment.equip((Armor)equipment);
        }
    }
}
