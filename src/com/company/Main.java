package com.company;


import com.company.ClassType.Barbarian;
import com.company.Equipment.Armor.Heavy_Armor.ChainMail;
import com.company.Equipment.Armor.Heavy_Armor.Plate;
import com.company.Equipment.Armor.Medium_Armor.ChainShirt;
import com.company.Equipment.Armor.Shield;
import com.company.Equipment.Weapon.SmipleWeapons.TwoHandedMelee.LongSpear;
import com.company.RaceType.Human;

public class Main {

    public static void main(String[] args) {
        PlayerCharacter brandon = new PlayerCharacter(new Human("Brandon"), new Barbarian(),
                new Bag("Traveler's Bag", 30));

        brandon.getInventoryBag().displayIteminBag();

        brandon.displayCharacterInformation();

        brandon.equipGear(PlayerCharacter.GearSlot.ARMOR,new Plate());
        brandon.equipGear(PlayerCharacter.GearSlot.RHAND,new Shield());

        brandon.displayCharacterInformation();

        System.out.println(brandon.getRole().get_ArmorProficiency(brandon.getGearEquipment(),
                PlayerCharacter.GearSlot.ARMOR));
        System.out.println(brandon.getRole().get_ChancetoHitBonus(brandon.getGearEquipment()));
    }

}
