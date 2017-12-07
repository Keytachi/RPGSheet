package com.company.Util;

import com.company.Bag;
import com.company.ClassType.Barbarian;
import com.company.Equipment.Armor.Medium_Armor.MediumArmor;
import com.company.Equipment.Armor.Medium_Armor.ChainShirt;
import com.company.Equipment.Armor.Shield;
import com.company.Equipment.Weapon.SmipleWeapons.OneHandedMelee.Club;
import com.company.Equipment.Weapon.SmipleWeapons.TwoHandedMelee.LongSpear;
import com.company.Equipment.Weapon.SmipleWeapons.TwoHandedMelee.QuarterStaff;
import com.company.PlayerCharacter;
import com.company.RaceType.Human;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {
    @Test
    void gearisInstance() {
        assertTrue(Util.gearisInstance(new Shield(), Shield.class));
        assertFalse(Util.gearisInstance(new ChainShirt(), MediumArmor.class));
    }

    @Test
    void equipGear(){
        PlayerCharacter brandon = new PlayerCharacter(new Human("Brandon"), new Barbarian(),
                new Bag("Traveler's Bag", 30));

        brandon.equip(new LongSpear(),EnumContainer.GearSlot.RHAND);

        brandon.equip(new Shield(),EnumContainer.GearSlot.LHAND);
        //Long Spear should be in bag now. 1


        brandon.equip(new Shield(),EnumContainer.GearSlot.LHAND);
        //Shield should be in bag now. 2
        brandon.equip(new Club(),EnumContainer.GearSlot.RHAND);
        //Two should be in bag now. 2
        brandon.equip(new LongSpear(), EnumContainer.GearSlot.RHAND);
        //Club and Shield should be in bag now. 4
        brandon.displayGear();

        brandon.getInventoryBag().displayItemsinBag();

        assertEquals(4,brandon.getInventoryBag().getInventoryBag().size());

    }

}