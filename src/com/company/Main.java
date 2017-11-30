package com.company;


import com.company.ClassType.Barbarian;
import com.company.Equipment.Armor.Armor;
import com.company.Equipment.Armor.Light_Armor.LightArmor;
import com.company.Equipment.Armor.Medium_Armor.ChainShirt;
import com.company.Equipment.Armor.Medium_Armor.MediumArmor;
import com.company.Equipment.Armor.Naked;
import com.company.Equipment.Weapon.Shield;
import com.company.RaceType.Human;

public class Main {

    public static void main(String[] args) {
        PlayerCharacter brandon = new PlayerCharacter(new Human("Brandon"), new Barbarian());

        System.out.println(brandon.getRole().get_ArmorProficiency(brandon.getArmorEquipment(),
                PlayerCharacter.GearSlot.ARMOR));

        brandon.equipGear(brandon.getArmorEquipment(), PlayerCharacter.GearSlot.ARMOR,new ChainShirt());
        brandon.equipGear(brandon.getWeaponEquipment(), PlayerCharacter.GearSlot.RHAND, new Shield());
        System.out.println(brandon.getRole().get_ArmorProficiency(brandon.getWeaponEquipment(),
                PlayerCharacter.GearSlot.ARMOR));
        System.out.println(Naked.class.isInstance(brandon.getArmorEquipment().get(PlayerCharacter.GearSlot.ARMOR)));
    }

}
