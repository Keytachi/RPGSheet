package com.company;

import com.company.ClassType.Barbarian;
import com.company.ClassType.ClassRole;
import com.company.ClassType.Mage;
import com.company.Equipment.Armor.Armor;
import com.company.Equipment.Armor.Heavy_Armor.HeavyArmor;
import com.company.Equipment.Armor.Light_Armor.LightArmor;
import com.company.Equipment.Armor.Medium_Armor.MediumArmor;
import com.company.Equipment.Equipment;
import com.company.Equipment.Naked;
import com.company.Equipment.Weapon.Shield;
import com.company.Equipment.Weapon.Weapon;
import com.company.RaceType.Race;

import java.util.HashMap;
import java.util.Map;

public class PlayerCharacter {

    private Race race;
    private ClassRole role;

    private int current_Health;
    private int maximum_Health;
    private int armor_Amount;

    private enum GearSlot{
        ARMOR,
        LHAND,
        RHAND
    }
    //TODO: Work on this armor part again.
    /**
     *  Idea: Hashmap<String, Armor>
     *  String = Body
     *  Armor = Any instanceof Armor.
     *
     *  Issue: Is it worth using hasmap for 1 item?
     */
    Map<GearSlot, Armor> armorEquipment = new HashMap<>();

    //TODO: Work on this weapon part again.
    /**
     Idea: Hashmap<String, Weapon> or a Map<String,Weapon>
     String = "Left Hand", "Right Hand"
     Weapon = Any instanceof Weapon. Should include shield.

     Issue: Shield is an instanceof an armor class
     */
    Map<GearSlot,Weapon> weaponEquipment = new HashMap<>();

    public PlayerCharacter(Race race, ClassRole role){
        this.race = race;
        this.role = role;
        setHealth();

        this.armorEquipment.put(GearSlot.ARMOR,null);
        this.weaponEquipment.put(GearSlot.LHAND,null);
        this.weaponEquipment.put(GearSlot.RHAND,null);
        setArmor_Amount();

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

    public void unEquipGear(Map characterGear, GearSlot gearSlot){

        /**
         * Compare if Gearslot = Armor then remove all armor value from the armor_amount value.
         * If Weapon then just remove it as there is no stats in a weapon.
         */

        characterGear.put(gearSlot,null);
    }

    public void equipGear(Map characterGear, GearSlot gearSlot, Equipment gear) {

        if (gear instanceof HeavyArmor || gear instanceof MediumArmor || gear instanceof LightArmor) {
            if (gearSlot == GearSlot.ARMOR) {
                characterGear.put(gearSlot, gear);
            }
        }
        else if (gear instanceof Weapon || gear instanceof Shield) {
            if (gearSlot == GearSlot.LHAND || gearSlot == GearSlot.RHAND) {
                if (characterGear.get(gearSlot) != null) {
                    unEquipGear(characterGear,gearSlot);
                }
                characterGear.put(gearSlot,gear);
            }
        }
    }

    public void setArmor_Amount(){
        if(armorEquipment.get(GearSlot.ARMOR) == null){
            equipGear(armorEquipment,GearSlot.ARMOR,new Naked());
        }
        if(this.weaponEquipment.get(GearSlot.RHAND) instanceof Shield){
            this.armor_Amount = this.armorEquipment.get(GearSlot.ARMOR).get_Armor() +
                    this.weaponEquipment.get(GearSlot.RHAND).get_Armor();
        }else if (this.weaponEquipment.get(GearSlot.LHAND) instanceof Shield){
            this.armor_Amount = this.armorEquipment.get(GearSlot.ARMOR).get_Armor() +
                    this.weaponEquipment.get(GearSlot.RHAND).get_Armor();
        }else{
            this.armor_Amount = this.armorEquipment.get(GearSlot.ARMOR).get_Armor();
        }
    }
}
