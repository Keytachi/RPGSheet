package com.company;


import com.company.ClassType.Barbarian;
import com.company.Items.Equipment.Armor.Shield;
import com.company.RaceType.Human;

public class Main {

    public static void main(String[] args) {
        PlayerCharacter brandon = new PlayerCharacter(new Human("Brandon"),new Barbarian(),new Bag("Bag",32));
        Shield testShield = new Shield();

        brandon.equip(testShield);
    }

}
