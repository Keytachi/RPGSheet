package com.company;

import com.company.ClassType.*;
import com.company.Equipment.Armor.Armor;
import com.company.Equipment.Armor.Heavy_Armor.HeavyArmor;
import com.company.Equipment.Armor.Light_Armor.LightArmor;
import com.company.Equipment.Armor.Medium_Armor.MediumArmor;
import com.company.Equipment.*;
import com.company.Equipment.Armor.Naked;
import com.company.Equipment.Weapon.*;
import com.company.RaceType.Race;

import java.util.HashMap;
import java.util.Map;

public class PlayerCharacter {

    private Race race;
    private ClassRole role;

    private int current_Health;
    private int maximum_Health;

    private static final int BASE_ARMOR = 10;

    public enum GearSlot{
        ARMOR,
        LHAND,
        RHAND
    }

    private Map<GearSlot, Armor> armorEquipment = new HashMap<>();
    private Map<GearSlot,Weapon> weaponEquipment = new HashMap<>();

    public PlayerCharacter(Race race, ClassRole role){
        this.race = race;
        this.role = role;
        setHealth();

        this.armorEquipment.put(GearSlot.ARMOR,new Naked());
        this.weaponEquipment.put(GearSlot.LHAND,new Unarm());
        this.weaponEquipment.put(GearSlot.RHAND,new Unarm());
    }

    public void setHealth(){
        if (this.role instanceof Barbarian){
            this.maximum_Health = 12 + this.race.getCons_Modifier();
            this.current_Health = this.maximum_Health;
        }
        else if (this.role instanceof Mage){
            this.maximum_Health = 8 + this.race.getCons_Modifier();
            this.current_Health = this.maximum_Health;
        }
    }


    public int getCurrent_Health() {
        return current_Health;
    }

    public void setCurrent_Health(int current_Health) {
        this.current_Health = current_Health;
        if(this.current_Health > this.maximum_Health){
            this.current_Health = this.maximum_Health;
        }
    }

    public int getMaximum_Health() {
        return maximum_Health;
    }
    public void setMaximum_Health(int maximum_Health) {
        this.maximum_Health = maximum_Health;
    }

    public Map<GearSlot, Armor> getArmorEquipment() {
        return armorEquipment;
    }

    public Map<GearSlot, Weapon> getWeaponEquipment() {
        return weaponEquipment;
    }

    public void unEquipGear(Map characterGear, GearSlot gearSlot){
        if(gearSlot == GearSlot.ARMOR){

            characterGear.put(gearSlot,new Naked());
        }
        else if (gearSlot == GearSlot.LHAND || gearSlot == GearSlot.RHAND){
            characterGear.put(gearSlot,new Unarm());
        }
    }

    public void equipGear(Map characterGear, GearSlot gearSlot, Equipment gear) {

        if (gear instanceof HeavyArmor || gear instanceof MediumArmor || gear instanceof LightArmor) {
            if (gearSlot == GearSlot.ARMOR) {
                characterGear.put(gearSlot, gear);
            }
        }
        else if (gear instanceof Weapon || gear instanceof Shield) {
            if (gearSlot == GearSlot.LHAND || gearSlot == GearSlot.RHAND) {
                if (characterGear.get(gearSlot) instanceof Naked == false) {
                    unEquipGear(characterGear,gearSlot);
                }
                characterGear.put(gearSlot,gear);
            }
        }
    }

    public Race getRace() {
        return race;
    }

    public ClassRole getRole() {
        return role;
    }

    public int setArmor_Amount(){
        if(this.weaponEquipment.get(GearSlot.RHAND) instanceof Shield){
            return BASE_ARMOR+ this.armorEquipment.get(GearSlot.ARMOR).get_Armor(this) +
                    this.weaponEquipment.get(GearSlot.RHAND).get_Armor();

        }else if (this.weaponEquipment.get(GearSlot.LHAND) instanceof Shield){
            return BASE_ARMOR+ this.armorEquipment.get(GearSlot.ARMOR).get_Armor(this) + +
                    this.weaponEquipment.get(GearSlot.RHAND).get_Armor();

        }else{
            return BASE_ARMOR+ this.armorEquipment.get(GearSlot.ARMOR).get_Armor(this);
        }
    }
}
