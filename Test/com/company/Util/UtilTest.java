package com.company.Util;

import com.company.Equipment.Armor.Medium_Armor.MediumArmor;
import com.company.Equipment.Armor.Medium_Armor.ChainShirt;
import com.company.Equipment.Armor.Shield;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {
    @Test
    void gearisInstance() {
        assertTrue(Util.gearisInstance(new Shield(), Shield.class));
        assertFalse(Util.gearisInstance(new ChainShirt(), MediumArmor.class));
    }

}