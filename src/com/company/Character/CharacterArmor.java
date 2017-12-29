package com.company.Character;

import com.company.Items.Equipment.Armor.Armor;
import com.company.Items.Equipment.Armor.Shield;
import com.company.RaceType.Stats.BonusStats;
import com.company.Spell.ASpell;
import com.company.Spell.Effect;
import com.company.Util.EnumContainer;
import com.company.Util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ble on 12/26/2017.
 */

public class CharacterArmor {
    private List<Effect> tempArmor;

    private int armor;
    private int final_Armor;
    private static final int BASE_ARMOR = 10;

    public CharacterArmor(){
        this.armor = BASE_ARMOR;
        tempArmor = new ArrayList<>();
    }
    public int getArmor() {
        return this.armor;
    }

    private void setArmor(PlayerCharacter character){
        for(Enum weaponSlot : EnumContainer.weapon_Slot){
            if(Util.gearisInstance(character.getGear_Equipment().getWeaponEquipment().get(weaponSlot),Shield.class)){
                this.armor  = BASE_ARMOR +
                        ((Armor) character.getGear_Equipment().getArmor(EnumContainer.GearSlot.ARMOR)).get_Armor(character) +
                        ((Armor) character.getGear_Equipment().getWeaponEquipment().get(weaponSlot)).get_Armor(character);
                break;
            }
            else{
                this.armor = BASE_ARMOR +
                        ((Armor) character.getGear_Equipment().getArmor(EnumContainer.GearSlot.ARMOR)).get_Armor(character);
                break;
            }
        }
    }

    public void setArmor(int armor){
        this.armor = armor;
    }
    public void updateArmor(PlayerCharacter character){
        setArmor(character);
    }

    public int getFinal_Armor() {
        return final_Armor;
    }


    public int calculateFinalArmor(){
        final_Armor = armor;
        tempArmor.forEach(x -> this.final_Armor += x.getStatsRate());
        return final_Armor;
    }

    public void addBonusArmor(Effect bonusArmors){
        tempArmor.add(bonusArmors);
    }

    public void removeBonusArmor(Effect bonusArmors){
        tempArmor.remove(bonusArmors);
    }
}
