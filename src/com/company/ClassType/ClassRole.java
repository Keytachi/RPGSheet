package com.company.ClassType;

import com.company.Equipment.Armor.Armor;
import com.company.Equipment.Equipment;
import com.company.Equipment.Weapon.Weapon;
import com.company.PlayerCharacter;
import com.company.RaceType.Race;
import com.company.Util.Util;
import com.company.Util.dice;

import java.util.Arrays;
import java.util.Map;

public abstract class ClassRole{

    protected Class<Armor> armorProficiencyList[];
    protected Class<Weapon> weaponProficiencyList[];
    protected Enum<PlayerCharacter.GearSlot> gearLocation[] = new Enum[]{
            PlayerCharacter.GearSlot.ARMOR,
            PlayerCharacter.GearSlot.LHAND,
            PlayerCharacter.GearSlot.RHAND
    };

    protected String[] choices = new String[]{};
    protected Equipment[] equipmentList = new Equipment[]{};

    protected dice hitDie;
    protected int proficiency;
    protected int level;

    public ClassRole(dice hitDie){
        this.hitDie = hitDie;
        this.level = 1;
        this.proficiency = set_Proficiency();
    }

    public int get_ArmorProficiency(Map gearEquipment, PlayerCharacter.GearSlot gearSlot) {
        if (Arrays.asList(armorProficiencyList).contains(gearEquipment.get(gearSlot))) {
            return this.proficiency;
        }
        return 0;
    }

    public int get_ChancetoHitBonus(Map gearEquipment){
        for(int i = 0; i < gearLocation.length; i++) {
            for(int weapon_Type = 0; weapon_Type < weaponProficiencyList.length; weapon_Type++){
                if(Util.gearisInstance(gearEquipment.get(gearLocation[i]),weaponProficiencyList[weapon_Type])){
                    return this.proficiency;
                }
            }
        }
        return 0;
    }

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
