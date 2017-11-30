package com.company.ClassType;
import com.company.Equipment.Armor.Light_Armor.LightArmor;
import com.company.Equipment.Armor.Medium_Armor.MediumArmor;
import com.company.Equipment.Armor.Naked;
import com.company.Equipment.Armor.Shield;
import com.company.Equipment.Weapon.MartialWeapons.MartialWeapons;
import com.company.Equipment.Weapon.SmipleWeapons.SimpleWeapon;
import com.company.PlayerCharacter;
import com.company.RaceType.Race;
import com.company.Util.Util;
import com.company.Util.dice;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.Arrays;
import java.util.Map;

public class Barbarian extends ClassRole {

    private int rage;

    public Barbarian(){
        super(new dice(12));
        this.rage = setRage();

        this.armorProficiencyList = new Class[]{
          LightArmor.class,
          MediumArmor.class,
          Shield.class
        };

        //TODO: Create an abstract of Simple and Martial Weapons.
        this.weaponProficiencyList = new Class[]{
                SimpleWeapon.class,
                MartialWeapons.class
        };
    }

    @Override
    public String toString(){
       return "Barbarian";
    }


    public int unArmored_Defense(PlayerCharacter person) {
        if(Util.gearisInstance(person.getGearEquipment().get(PlayerCharacter.GearSlot.ARMOR), Naked.class)){
            return person.getArmor_Amount() + person.getRace().getCons_Modifier();
        }
        return 0;
    }

    @Override
    public int get_ArmorProficiency(Map gearEquipment, PlayerCharacter.GearSlot gearSlot) {
        for (int armor_Type = 0; armor_Type < armorProficiencyList.length; armor_Type++) {
            if (Util.gearisInstance(gearEquipment.get(gearSlot), armorProficiencyList[armor_Type])) {
                return this.proficiency;
            }

            //TODO: Understand how to use this contains for subclass.
            /**if(Arrays.asList(armorProficiencyList).contains((Class)gearEquipment.get(gearSlot))){
             return this.proficiency;
             }*/

            for (int slot = 0; slot < gearLocation.length; slot++) {
                if (Util.gearisInstance(gearEquipment.get(gearLocation[slot]), Shield.class)) {
                    return this.proficiency;
                }
            }
        }
        return 0;
    }


    public int setRage() {
        if (level >= 1 && level <= 2){
            return 2;
        }else if (level >= 3 && level <= 5){
            return 3;
        }else if (level >= 6 && level <= 11){
            return 4;
        }else if (level >= 12 && level <= 16){
            return 5;
        }else if (level >= 17  && level <= 19){
            return 6;
        }else if (level == 20){
            return 100;
        }
        return 0;
    }
}
