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
import com.company.Util.Util;

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

    private Map<GearSlot,Equipment> gearEquipment = new HashMap<>();

    public PlayerCharacter(Race race, ClassRole role){
        this.race = race;
        this.role = role;
        setHealth();

        this.gearEquipment.put(GearSlot.ARMOR,new Naked());
        this.gearEquipment.put(GearSlot.LHAND,new Unarm());
        this.gearEquipment.put(GearSlot.RHAND,new Unarm());
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

    public Map<GearSlot, Equipment> getGearEquipment() {
        return gearEquipment;
    }

    public void unEquipGear(GearSlot gearSlot){
        if(gearSlot == GearSlot.ARMOR){
            gearEquipment.put(gearSlot,new Naked());
        }
        else if (gearSlot == GearSlot.LHAND || gearSlot == GearSlot.RHAND){
            gearEquipment.put(gearSlot,new Unarm());
        }
    }

    public void equipGear(GearSlot gearSlot, Equipment gear) {

        if (Util.gearisInstance(gear, HeavyArmor.class) ||Util.gearisInstance(gear, MediumArmor.class)
                || Util.gearisInstance(gear, LightArmor.class)) {
            if (gearSlot == GearSlot.ARMOR) {
                gearEquipment.put(gearSlot, gear);
            }
        }
        else if (Util.gearisInstance(gear, Weapon.class) || Util.gearisInstance(gear,Shield.class)){
            if (gearSlot == GearSlot.LHAND || gearSlot == GearSlot.RHAND) {
                if (gearEquipment.get(gearSlot) instanceof Naked == false) {
                    unEquipGear(gearSlot);
                }
                gearEquipment.put(gearSlot,gear);
            }
        }
    }

    public Race getRace() {
        return race;
    }

    public ClassRole getRole() {
        return role;
    }

    public int getArmor_Amount(){

        Armor armor = (Armor)gearEquipment.get(GearSlot.ARMOR);
        Armor rShield = (Armor)gearEquipment.get(GearSlot.RHAND);
        Armor lShield = (Armor)gearEquipment.get(GearSlot.LHAND);

        if(Util.gearisInstance(this.gearEquipment.get(GearSlot.RHAND), Shield.class)){
            return BASE_ARMOR+ armor.get_Armor(this) + rShield.get_Armor();

        }else if (Util.gearisInstance(this.gearEquipment.get(GearSlot.LHAND), Shield.class)){
            return BASE_ARMOR+ armor.get_Armor(this) + lShield.get_Armor();

        }else{
            return BASE_ARMOR+ armor.get_Armor(this);
        }
    }
}
