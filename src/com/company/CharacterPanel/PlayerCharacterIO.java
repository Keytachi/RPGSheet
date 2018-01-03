package com.company.CharacterPanel;

import com.company.Character.PlayerCharacter;
import com.company.Items.Equipment.Item;
import com.company.RaceType.Stats.AttributeEnum;
import com.company.Util.EnumContainer;

public class PlayerCharacterIO {

    public static void header(String s){
        System.out.println("==========================================");
        System.out.println(s);
        System.out.println("==========================================");
    }

    public static void displayCharacterStats(PlayerCharacter host){
        header(host.getName() + "'s Stats");
        host.get_Race().getAttributeStats().keySet().forEach(attribute -> System.out.println( attribute + " : " +
        host.get_Race().getAttributeStatsValue(attribute)));
        System.out.println("");
    }

    public static void displayCharacterModifier(PlayerCharacter host){
        header(host.getName() + "'s Modifier");
        host.get_Race().getModifyStats().keySet().forEach(attribute -> System.out.println( attribute + " : " +
        host.get_Race().getModifyStatsValue(attribute)));
        System.out.println("");
    }

    public static void displayGear(PlayerCharacter host){
        header(host.getName() + "'s Equipment");
        EnumContainer.weapon_Slot.forEach(hand -> System.out.println(hand + " : " + host.get_GearEquipment().getWeapon(hand)));
        System.out.println(EnumContainer.GearSlot.ARMOR + " : " + host.get_GearEquipment().getArmor(EnumContainer.GearSlot.ARMOR));
        System.out.println("");
    }

    public static void displayInventory(PlayerCharacter host){
        header(host.getName() + "'s Inventory");
        host.get_InventoryBag().getInventoryBag().forEach(items -> System.out.println(items));
    }

    public static void displayHealth(PlayerCharacter host){
        header(host.getName() + "'s Health");
        System.out.println(host.get_CurrentHealth().getFinalValue() + " / " + host.get_MaximumHealth().getFinalValue());
    }

    public static void displayEXP(PlayerCharacter host){
        header(host.getName() + "'s Current Exp");
        System.out.println("Level " + host.get_Level().get_Level() + " : " +
                host.get_Level().get_CurrentEXP() + "/" + host.get_Level().get_EXPReq());
    }

    public static void displayHeightWeight(PlayerCharacter host){
        header(host.getName() + "'s Height/Weight");
        System.out.println("Height: " + host.get_Race().getHeight().get_BaseHeight() +
        " inches.");
        System.out.println("Weight: " + host.get_Race().getHeight().get_BaseWeight() + " lbs.");
    }
}
