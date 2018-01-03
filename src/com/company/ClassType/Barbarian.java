package com.company.ClassType;
import com.company.Items.Equipment.Armor.Light_Armor.ALight;
import com.company.Items.Equipment.Armor.Medium_Armor.AMedium;
import com.company.Items.Equipment.Armor.Naked;
import com.company.Items.Equipment.Armor.Shield;
import com.company.Character.PlayerCharacter;
import com.company.Items.Equipment.Weapon.Martial.AMartialWeapon;
import com.company.Items.Equipment.Weapon.Simple.ASimpleWeapon;
import com.company.RaceType.Stats.AttributeEnum.AttributeModify;
import com.company.Spell.Buff;
import com.company.Spell.Effect;
import com.company.Util.EnumContainer;
import com.company.Util.Util;
import com.company.Util.dice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class Barbarian extends ClassRole {

    public Barbarian() {
        super(new dice(12));
        this.armorProficiencyList = new HashSet<>(Arrays.asList(AMedium.class,ALight.class,Shield.class));
        this.weaponProficiencyList = new HashSet<>(Arrays.asList(AMartialWeapon.class, ASimpleWeapon.class));

    }

    @Override
    public String toString(){
       return "Barbarian";
    }


    public void unArmored_Defense(PlayerCharacter person) {
        if(Util.gearisInstance(person.get_GearEquipment().getArmor(EnumContainer.GearSlot.ARMOR),
                Naked.class)){
            person.get_Armor().addTempBuff(new Buff(3, "Unarmored Defense", Effect.Effects_Type.Buff,
                    person.getModifyStatsValue(AttributeModify.Con_Modifier),
                    Effect.Target_Type.Armor));
        }
        else{
            person.get_Armor().removeTempBuff("Unarmored Defense");
        }
    }

    @Override
    public int get_ArmorProficiency(Map gearEquipment, EnumContainer.GearSlot gearSlot) {
        for (Class armor_Type : armorProficiencyList) {
            if (Util.gearisInstance(gearEquipment.get(gearSlot), armor_Type)) {
                return this.proficiency;
            }
        }
        for (EnumContainer.GearSlot weaponSlot : EnumContainer.weapon_Slot) {
            if (Util.gearisInstance(gearEquipment.get(weaponSlot), Shield.class)) {
                return this.proficiency;
            }
        }
        return 0;
    }
}
