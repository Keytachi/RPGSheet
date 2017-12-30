package com.company.Character;

import com.company.Bag;
import com.company.CharacterPanel.Armor;
import com.company.CharacterPanel.CharacterInformation;
import com.company.ClassType.*;
import com.company.Items.Equipment.Armor.IArmor;
import com.company.Items.Equipment.*;
import com.company.Items.Equipment.Weapon.IWeapon;
import com.company.RaceType.Race;
import com.company.RaceType.Stats.AttributeEnum.Attribute;
import com.company.Util.EnumContainer;

import java.util.HashMap;

public class PlayerCharacter {

    private Race race;
    private ClassRole role;
    private Bag inventoryBag;
    private EquipmentSystem gear_Equipment;
    private CharacterInformation maximum_health;
    private CharacterInformation current_Health;
    private Armor armor;
    private CharacterInformation walking_Speed;

    private String name;


    public PlayerCharacter(String name, Race race, ClassRole role, Bag inventoryBag){
        this.name = name;
        this.race = race;
        this.role = role;
        this.gear_Equipment = new EquipmentSystem();
        this.inventoryBag = inventoryBag;
        this.armor = new Armor();
        this.walking_Speed = new CharacterInformation(30);
        setHealth();
        updatePlayer();
    }



    //Composition of other classes that are being built in this class.
    public Race get_Race() {
        return race;
    }
    public ClassRole get_Role() {
        return role;
    }
    public Bag get_InventoryBag(){
        return inventoryBag;
    }
    public EquipmentSystem getGear_Equipment() {
        return gear_Equipment;
    }
    public Armor getArmor(){ return armor;}
    public CharacterInformation getWalking_Speed(){
        return walking_Speed;
    }



    public CharacterInformation getCurrent_Health() {
        return current_Health;
    }

    public CharacterInformation getMaximum_health() {
        return maximum_health;
    }

    /**
     * Work on this when creating more classes.
     * THIS IS ONLY INTENDED FOR INSTANTIATING THE CHARACTER!
     */
    private void setHealth(){
        if (role instanceof Barbarian){
            this.maximum_health = new CharacterInformation(12 + race.getBaseStats(Attribute.Constitution).getFinalValue());
            this.current_Health = new CharacterInformation(maximum_health.getFinalValue());
        }
        else if (role instanceof Wizard){
            this.maximum_health = new CharacterInformation(8 + race.getBaseStats(Attribute.Constitution).getFinalValue());
            this.current_Health = new CharacterInformation(maximum_health.getFinalValue());
        }
    }

    public int getMax_BagWeight(){
        return race.getBaseStats(Attribute.Strength).getFinalValue() * 15;
    }


    public void updatePlayer(){
        inventoryBag.setMaxBagWeight(getMax_BagWeight() * 15);
        updateArmor();
        if(role instanceof Barbarian){
            ((Barbarian)role).unArmored_Defense(this);
        }
    }

    private void updateArmor(){
        armor.update(this);
    }

    public void equip(IWeapon equipment, EnumContainer.GearSlot slot){
            try {
                gear_Equipment.equip( equipment, slot, this);
            }catch(NotCorrectSlotException e){
                System.out.println(e.getEquipment() + " can not be equipped on " + e.getSlot());
            }
    }
    public void equip(IEquipment equipment){
        if(equipment instanceof IWeapon){
            gear_Equipment.equip((IWeapon)equipment, this);
        }
        else if(equipment instanceof IArmor){
            gear_Equipment.equip((IArmor)equipment, this);
        }
        updatePlayer();
    }

    public String getName(){
        return this.name;
    }
}
