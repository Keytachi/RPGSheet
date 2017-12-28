package com.company.ClassType;
import com.company.Items.Equipment.Armor.Light_Armor.ALight;
import com.company.Items.Equipment.Armor.Medium_Armor.AMedium;
import com.company.Items.Equipment.Armor.Naked;
import com.company.Items.Equipment.Armor.Shield;
import com.company.Character.PlayerCharacter;
import com.company.Items.Equipment.Weapon.Martial.AMartialWeapon;
import com.company.Items.Equipment.Weapon.Simple.ASimpleWeapon;
import com.company.RaceType.Stats.AttributeEnum.AttributeModify;
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

        this.armorProficiencyList = new HashSet<>(Arrays.asList(AMedium.class,ALight.class,Shield.class));
        this.weaponProficiencyList = new HashSet<>(Arrays.asList(AMartialWeapon.class, ASimpleWeapon.class));

    }

    @Override
    public String toString(){
       return "Barbarian";
    }


    public void unArmored_Defense(PlayerCharacter person) {
        if(Util.gearisInstance(person.getGear_Equipment().getArmorEquipment().get(EnumContainer.GearSlot.ARMOR),
                Naked.class)){
            person.get_Armor().getFinal_Armor();
            person.get_Armor().addBonusArmor(person.get_Race().getModifierStats(AttributeModify.Con_Modifier).getFinalModifier());
        }
        else{
            person.get_Armor().removeBonusArmor(person.get_Race().getModifierStats(AttributeModify.Con_Modifier).getFinalModifier());
        }
        person.get_Armor().calculateFinalArmor();
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
