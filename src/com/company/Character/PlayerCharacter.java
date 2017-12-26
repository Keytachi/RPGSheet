package com.company.Character;

import com.company.Bag;
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
    private Health health;

    private String name;


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
            this.health.setMaximum_Health(12 + race.getCons_Modifier());
            this.health.setCurrent_Health(this.health.getMaximum_Health());
        }
        else if (role instanceof Wizard){
            this.health.setMaximum_Health(8 + race.getCons_Modifier());
            this.health.setCurrent_Health(this.health.getMaximum_Health());
        }
    }


    public int getMax_BagWeight(){
        return race.getStrength() * 15;
    }

    public Health getHealth(){
        return this.health;
    }

    public void displayGear(){
        System.out.println("Currently equip on " + this.race.getName());
        for(GearSlot hand : EnumContainer.weapon_Slot){
            System.out.println(hand + " : " + gear_Equipment.getWeaponEquipment().get(hand));
        }
        System.out.println(GearSlot.ARMOR + " : " +
                gear_Equipment.getArmorEquipment().get(GearSlot.ARMOR));

    }

    public void updatePlayer(){
        inventoryBag.setMaxBagWeight(getMax_BagWeight() * 15);
        if(role instanceof Barbarian){
            ((Barbarian)role).unArmored_Defense(this);
        }
    }

    public void equip(Abstract_Equipment equipment){
        if(equipment instanceof Weapon){
            gear_Equipment.equip((Weapon)equipment, this);
        }
        else if(equipment instanceof Armor){
            gear_Equipment.equip((Armor)equipment, this);
        }
    }
}
