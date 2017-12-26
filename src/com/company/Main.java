package com.company;


import com.company.ClassType.Barbarian;
import com.company.Items.Equipment.Armor.Heavy_Armor.ChainMail;
import com.company.Items.Equipment.Armor.Shield;
import com.company.Items.Equipment.Weapon.Simple.SimpleTwoHand.GreatClub;
import com.company.RaceType.Human;
import com.company.Test_Class.Test_Elf;
import com.company.Test_Class.Test_HighElf;
import com.company.Test_Class.Test_Human;
import com.company.Test_Class.Test_Race;

public class Main {

    public static void main(String[] args) {
        /**PlayerCharacter brandon = new PlayerCharacter(new Human("Brandon"),
                new Barbarian(),new Bag("Bag",32));
        ChainMail testHeavy = new ChainMail();
        Shield testShield = new Shield();

        brandon.equip(testHeavy);
        brandon.equip(testShield);
        System.out.println("");
        brandon.getInventoryBag().displayItemsinBag();

        brandon.displayGear();
        GreatClub test2HClub = new GreatClub();

        brandon.equip(test2HClub);
        brandon.displayGear();
        System.out.println("");
        brandon.getInventoryBag().displayItemsinBag();
        **/

        //Test_Race tester = new Test_Human();
        Test_Race tester2 = new Test_HighElf(17,18,16,19,16,19);
        //tester.displayStats();
        tester2.displayStats();
    }

}
