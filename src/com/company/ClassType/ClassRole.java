package com.company.ClassType;

import com.company.Character.LevelSystem;
import com.company.Character.PlayerCharacter;
import com.company.Items.Equipment.Armor.Naked;
import com.company.RaceType.Stats.AttributeEnum;
import com.company.Spell.Buff;
import com.company.Spell.Effect;
import com.company.Util.EnumContainer;
import com.company.Util.Util;
import com.company.Util.dice;

import java.util.Map;
import java.util.Set;

public abstract class ClassRole{

    protected Set<Class> armorProficiencyList;
    protected Set<Class> weaponProficiencyList;


    protected dice hitDie;
    protected int proficiency;
    protected LevelSystem level;

    public ClassRole(dice hitDie){
        this.hitDie = hitDie;
        this.level = new LevelSystem();
        this.proficiency = 2;
    }

    public Set<Class> getArmorProficiencyList() {
        return armorProficiencyList;
    }

    public void setArmorProficiencyList(Set<Class> armorProficiencyList) {
        this.armorProficiencyList = armorProficiencyList;
    }

    public Set<Class> getWeaponProficiencyList() {
        return weaponProficiencyList;
    }

    public void setWeaponProficiencyList(Set<Class> weaponProficiencyList) {
        this.weaponProficiencyList = weaponProficiencyList;
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

    public LevelSystem get_Level() {
        return level;
    }

    public int roll_HitDie(){
        return hitDie.roll();
    }

    private void set_Proficiency() {
        if ((level.get_Level() % 4) == 0) {
            this.proficiency += 1;
        }
    }

    private void unArmored_Defense(PlayerCharacter person) {
        if(Util.gearisInstance(person.get_GearEquipment().getArmor(EnumContainer.GearSlot.ARMOR),
                Naked.class)){
            person.get_Armor().addTempBuff(new Buff(3, "Unarmored Defense", Effect.Effects_Type.Buff,
                    person.getModifyStatsValue(AttributeEnum.AttributeModify.Con_Modifier),
                    Effect.Target_Type.Armor));
        }
        else{
            person.get_Armor().removeTempBuff("Unarmored Defense");
        }
    }

    public void update(PlayerCharacter host){
        set_Proficiency();
        //TODO: Get all the class that can benefit from UnArmored Defense.
        if(host.get_CRole() instanceof Barbarian || host.get_CRole() instanceof Barbarian)
        unArmored_Defense(host);
    }
}
