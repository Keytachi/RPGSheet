package com.company;


import com.company.ClassType.Barbarian;
import com.company.Equipment.Armor.Medium_Armor.ChainShirt;
import com.company.Equipment.Armor.Shield;
import com.company.RaceType.Human;

public class Main {

    public static void main(String[] args) {
        PlayerCharacter brandon = new PlayerCharacter(new Human("Brandon"), new Barbarian());

        brandon.equipGear(PlayerCharacter.GearSlot.ARMOR,new ChainShirt());
        brandon.equipGear(PlayerCharacter.GearSlot.RHAND,new Shield());

        System.out.println(brandon.getRole().get_ArmorProficiency(brandon.getGearEquipment(),
                PlayerCharacter.GearSlot.ARMOR));
        System.out.println(brandon.getRole().get_ChancetoHitBonus(brandon.getGearEquipment()));
    }

}
