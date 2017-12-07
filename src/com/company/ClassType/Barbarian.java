package com.company.ClassType;
import com.company.Equipment.Armor.Light_Armor.LightArmor;
import com.company.Equipment.Armor.Medium_Armor.MediumArmor;
import com.company.Equipment.Armor.Naked;
import com.company.Equipment.Armor.Shield;
import com.company.Equipment.Weapon.MartialWeapons.MartialWeapons;
import com.company.Equipment.Weapon.SmipleWeapons.SimpleWeapon;
import com.company.PlayerCharacter;
import com.company.Util.EnumContainer;
import com.company.Util.Util;
import com.company.Util.dice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class Barbarian extends ClassRole {

    private int rage;

    public Barbarian() {
        super(new dice(12));
        this.rage = setRage();

        this.armorProficiencyList = new HashSet<>(Arrays.asList(MediumArmor.class,LightArmor.class,Shield.class));

        //TODO: Create an abstract of Simple and Martial Weapons.
        this.weaponProficiencyList = new HashSet<>(Arrays.asList(SimpleWeapon.class,MartialWeapons.class));
    }

    @Override
    public String toString(){
       return "Barbarian";
    }


    public void unArmored_Defense(PlayerCharacter person) {
        if(Util.gearisInstance(person.getGear_Equipment().getGearEquipment().get(EnumContainer.GearSlot.ARMOR),
                Naked.class)){
            person.setArmor_Amount(person.getArmor_Amount() + person.getRace().getCons_Modifier());
        }
    }

    @Override
    public int get_ArmorProficiency(Map gearEquipment, EnumContainer.GearSlot gearSlot) {
        for (Class armor_Type : armorProficiencyList) {
            if (Util.gearisInstance(gearEquipment.get(gearSlot), armor_Type)) {
                return this.proficiency;
            }
        }
        for (Enum<EnumContainer.GearSlot> weaponSlot : EnumContainer.weapon_Slot) {
            if (Util.gearisInstance(gearEquipment.get(weaponSlot), Shield.class)) {
                return this.proficiency;
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
