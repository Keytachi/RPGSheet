package com.company.ClassType;

import com.company.Equipment.Armor.Armor;
import com.company.Equipment.Equipment;
import com.company.Equipment.Weapon.Weapon;
import com.company.PlayerCharacter;
import com.company.RaceType.Race;
import com.company.Util.EnumContainer;
import com.company.Util.Util;
import com.company.Util.dice;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public abstract class ClassRole{

    protected Set<Class> armorProficiencyList;
    protected Set<Class> weaponProficiencyList;

    protected String[] choices = new String[]{};

    protected dice hitDie;
    protected int proficiency;
    protected int level;

    public ClassRole(dice hitDie){
        this.hitDie = hitDie;
        this.level = 1;
        this.proficiency = set_Proficiency();
    }

    public int get_ArmorProficiency(Map gearEquipment, EnumContainer.GearSlot gearSlot) {
        for(Class armor_Type: armorProficiencyList) {
            if(Util.gearisInstance(gearEquipment.get(gearSlot),armor_Type)){
                return this.proficiency;
            }
        }
        return 0;
    }

    public int get_ChancetoHitBonus(Map gearEquipment){
        for(Enum<EnumContainer.GearSlot> gear_Slot : EnumContainer.weapon_Slot) {
            for(Class weapon_Type : weaponProficiencyList){
                if(Util.gearisInstance(gearEquipment.get(gear_Slot),weapon_Type)){
                    return this.proficiency;
                }
            }
        }
        return 0;
    }

    //TODO: Create a function that when per level, will increase the health pool of the character.

    /**TODO: Rethink about this usage.
     *  Either use this as is or use a Map<Integer,Integer> and compare the key to the level to get the
     *  proficiency.
     */
    public int set_Proficiency(){
        if(level >= 1 || level <= 4){
            return 2;
        }
        else if (level >= 5 || level <= 8){
            return 3;
        }
        else if(level >= 9 || level <= 12){
            return 4;
        }
        else if(level >= 13 || level <= 16){
            return 5;
        }
        else if (level >= 17 || level <= 20){
            return 6;
        }
        return 0;
    }
}
