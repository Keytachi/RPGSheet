package com.company;


import com.company.ClassType.Barbarian;
import com.company.Equipment.Armor.Heavy_Armor.ChainMail;
import com.company.Equipment.Armor.Heavy_Armor.Plate;
import com.company.Equipment.Armor.Medium_Armor.ChainShirt;
import com.company.Equipment.Armor.Shield;
import com.company.Equipment.Weapon.SmipleWeapons.TwoHandedMelee.LongSpear;
import com.company.RaceType.Human;
import com.company.Util.EnumContainer;

public class Main {

    public static void main(String[] args) {
        PlayerCharacter brandon = new PlayerCharacter(new Human("Brandon"), new Barbarian(),
                new Bag("Traveler's Bag", 30));

        brandon.displayGear();
        brandon.getInventoryBag().displayItemsinBag();
        System.out.println("Armor Amount: " + brandon.getArmor_Amount());

        brandon.equipGear(EnumContainer.GearSlot.ARMOR,new Plate());

        brandon.equipGear(EnumContainer.GearSlot.RHAND, new LongSpear());
        System.out.println("Armor Amount: " + brandon.getArmor_Amount());
        brandon.displayGear();

        System.out.println(brandon.getRole().get_ArmorProficiency(brandon.getGearEquipment(),
                EnumContainer.GearSlot.ARMOR));
        System.out.println(brandon.getRole().get_ChancetoHitBonus(brandon.getGearEquipment()));
    }

}
