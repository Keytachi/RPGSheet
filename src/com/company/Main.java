package com.company;


import com.company.Character.PlayerCharacter;
import com.company.ClassType.Barbarian;
import com.company.Items.Equipment.Armor.Heavy_Armor.ChainMail;
import com.company.Items.Equipment.Armor.Shield;
import com.company.RaceType.Human;

public class Main {

    public static void main(String[] args) {
        PlayerCharacter brandon = new PlayerCharacter("Brandon",new Human(),
                new Barbarian(),new Bag("Bag",32));

        brandon.get_Race().displayStats();
        System.out.println(brandon.get_Armor().getFinal_Armor());

        brandon.equip(new ChainMail());
        brandon.equip(new Shield());
        System.out.println(brandon.get_Armor().getFinal_Armor());

        /**Race tester = new Race(17,18,16,19,16,19);
        Test_Race tester2 = new Test_HighElf(17,18,16,19,16,19);
        //tester.displayStats();
        tester2.displayStats();

        tester.displayStats();
        **/
    }

}
