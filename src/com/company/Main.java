package com.company;

import com.company.ClassType.Barbarian;
import com.company.Equipment.Armor.Armor;
import com.company.Equipment.Armor.Heavy_Armor.HeavyArmor;
import com.company.Equipment.Armor.Heavy_Armor.Plate;
import com.company.Equipment.Armor.Light_Armor.LightArmor;
import com.company.Equipment.Armor.Medium_Armor.MediumArmor;
import com.company.Equipment.Armor.Shield;
import com.company.Equipment.Equipment;
import com.company.Equipment.Naked;
import com.company.Equipment.Weapon.Weapon;
import com.company.IO.IO;
import com.company.RaceType.Elf;
import com.company.RaceType.Human;
import com.company.RaceType.Race;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {

    public enum GearSlot{
        ARMOR,
        LHAND,
        RHAND
    }


    public static void main(String[] args) {
        Map<GearSlot,Armor> gearSlotEquipment = new HashMap<GearSlot,Armor>();
        Map<GearSlot,Weapon> weaponSlotEquipment = new HashMap<GearSlot,Weapon>();


       gearSlotEquipment.put(GearSlot.ARMOR,null);
       gearSlotEquipment.put(GearSlot.LHAND,null);
       gearSlotEquipment.put(GearSlot.RHAND,null);

       equipGear(gearSlotEquipment, GearSlot.ARMOR, new Plate());
       equipGear(gearSlotEquipment, GearSlot.LHAND, new Shield());

       System.out.println(gearSlotEquipment.get(GearSlot.ARMOR));
       System.out.println(gearSlotEquipment.get(GearSlot.LHAND));

    }

    public static void unEquipGear(Map characterGear, GearSlot gearSlot){

        /**
         * Compare if Gearslot = Armor then remove all armor value from the armor_amount value.
         * If Weapon then just remove it as there is no stats in a weapon.
         */

        characterGear.put(gearSlot,null);
    }

    public static void equipGear(Map characterGear, GearSlot gearSlot, Equipment gear) {

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
}
