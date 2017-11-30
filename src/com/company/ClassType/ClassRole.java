package com.company.ClassType;

import com.company.Equipment.Armor.Armor;
import com.company.Equipment.Armor.Light_Armor.LightArmor;
import com.company.Equipment.Armor.Medium_Armor.MediumArmor;
import com.company.Equipment.Equipment;
import com.company.Equipment.Weapon.Club;
import com.company.Equipment.Weapon.Shield;
import com.company.Equipment.Weapon.Weapon;
import com.company.PlayerCharacter;
import com.company.RaceType.Race;
import com.company.Util.dice;

import java.util.ArrayList;
import java.util.Map;

public abstract class ClassRole{

    protected Class<Armor> equipmentProficiency[] = new Class[]{};

    protected Enum<PlayerCharacter.GearSlot> gearSlot[] = new Enum[]{
            PlayerCharacter.GearSlot.ARMOR,
            PlayerCharacter.GearSlot.RHAND,
            PlayerCharacter.GearSlot.LHAND
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

    //TODO: Edit this implementation in other subclasses to use weapons * strength.
    public abstract void attack(Race target);

    public abstract int get_ArmorProficiency(Map gearEquipment, PlayerCharacter.GearSlot gearSlot);
    /**public int weapon_Proficiency(Map gearEquipment, PlayerCharacter.GearSlot gearSlot){

        for(int i = 0; i < weapons.length; i++){
            if(gearEquipment.get(gearSlot) instanceof weapons[i]){
                return proficiency;
            }
        }
        return 0;
    }*/

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
