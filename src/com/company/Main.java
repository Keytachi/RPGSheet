package com.company;


import com.company.Character.PlayerCharacter;
import com.company.IO.PlayerCharacterIO;
import com.company.ClassType.Barbarian;
import com.company.Items.Equipment.Armor.Heavy_Armor.ChainMail;
import com.company.Items.Equipment.Armor.Shield;
import com.company.Items.Equipment.IEquipment;
import com.company.Items.Equipment.Weapon.Simple.SimpleMeleeWeapon.Club;
import com.company.Items.Equipment.Weapon.Simple.SimpleTwoHand.GreatClub;
import com.company.RaceType.Human;
import com.company.RaceType.Stats.AttributeEnum;
import com.company.Spell.ASpell;
import com.company.Spell.Buff;
import com.company.Spell.Effect;
import com.company.Util.EnumContainer;

public class Main {

    public static void main(String[] args) {
        PlayerCharacter brandon = new PlayerCharacter("Brandon",new Human(),
                new Barbarian(),new Bag("Bag",32));
/**
        brandon.equip(new ChainMail());
        brandon.equip(new Shield());
        brandon.equip(new Club());
        PlayerCharacterIO.displayGear(brandon);
        PlayerCharacterIO.displayInventory(brandon);

        brandon.equip(new GreatClub());
        PlayerCharacterIO.displayGear(brandon);
        PlayerCharacterIO.displayInventory(brandon);

        brandon.equip((IEquipment)brandon.get_InventoryBag().getInventory(0));
        brandon.get_InventoryBag().removeItem(brandon.get_InventoryBag().getInventory(0));
        PlayerCharacterIO.displayGear(brandon);
        PlayerCharacterIO.displayInventory(brandon);

        brandon.equip((IEquipment)brandon.get_InventoryBag().getInventory(0));
        brandon.get_InventoryBag().removeItem(brandon.get_InventoryBag().getInventory(0));
        PlayerCharacterIO.displayGear(brandon);
        PlayerCharacterIO.displayInventory(brandon);

        brandon.equip((IEquipment)brandon.get_InventoryBag().getInventory(0));
        brandon.get_InventoryBag().removeItem(brandon.get_InventoryBag().getInventory(0));
        PlayerCharacterIO.displayGear(brandon);
        PlayerCharacterIO.displayInventory(brandon);
*/
        PlayerCharacterIO.displayCharacterStats(brandon);
        System.out.println(brandon.get_Race().getWalking_Speed());
        ASpell fireball = new ASpell(1,"Fireball",1,6);
        fireball.addEffect(new Buff(2, "Burn",Effect.Effects_Type.Buff,-2, AttributeEnum.Attribute.Dexterity,2, Effect.Target_Type.Attribute));
        fireball.attack(brandon);

        ASpell frost = new ASpell(3,"Frostbolt", 1, 6);
        frost.addEffect(new Effect(2,"Freeze", Effect.Effects_Type.Debuff,30,2, Effect.Target_Type.Walk));
        frost.attack(brandon);


        PlayerCharacterIO.displayCharacterStats(brandon);
        System.out.println(brandon.get_Race().getWalking_Speed());
        System.out.println(brandon.getName() + " is affect by this spell");
        System.out.println(brandon.get_Race().getBaseStats(AttributeEnum.Attribute.Dexterity).getTempStats());
        /**System.out.println(brandon.get_Armor().getFinal_Armor());

        PlayerCharacterIO.displayCharacterStats(brandon);
        PlayerCharacterIO.displayCharacterModifier(brandon);


        /**Race tester = new Race(17,18,16,19,16,19);
        Test_Race tester2 = new Test_HighElf(17,18,16,19,16,19);
        //tester.displayStats();
        tester2.displayStats();

        tester.displayStats();
        **/
    }
}
