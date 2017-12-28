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
import com.company.Util.EnumContainer;

public class Main {

    public static void main(String[] args) {
        PlayerCharacter brandon = new PlayerCharacter("Brandon",new Human(),
                new Barbarian(),new Bag("Bag",32));

        brandon.equip(new ChainMail());
        brandon.equip(new Shield());
        brandon.equip(new Club());
        brandon.equip(new GreatClub());
        PlayerCharacterIO.displayGear(brandon);
        PlayerCharacterIO.displayInventory(brandon);

        brandon.equip((IEquipment)brandon.get_InventoryBag().getInventoryBag().get(0));
        PlayerCharacterIO.displayGear(brandon);
        PlayerCharacterIO.displayInventory(brandon);
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
