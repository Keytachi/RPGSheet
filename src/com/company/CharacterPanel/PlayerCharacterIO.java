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
        host.get_Race().getAttributeStats().keySet().forEach(x -> System.out.println( x + " : " +
        host.get_Race().getAttributeStatsValue(x)));
        System.out.println("");
    }

    public static void displayCharacterModifier(PlayerCharacter host){
        header(host.getName() + "'s Modifier");
        host.get_Race().getModifyStats().keySet().forEach(x -> System.out.println( x + " : " +
        host.get_Race().getModifyStatsValue(x)));
        System.out.println("");
    }

    public static void displayGear(PlayerCharacter host){
        header(host.getName() + "'s Equipment");
        EnumContainer.weapon_Slot.forEach(x -> System.out.println(x + " : " + host.get_GearEquipment().getWeapon(x)));
        System.out.println(EnumContainer.GearSlot.ARMOR + " : " + host.get_GearEquipment().getArmor(EnumContainer.GearSlot.ARMOR));
        System.out.println("");
    }

    public static void displayInventory(PlayerCharacter host){
        header(host.getName() + "'s Inventory");
        host.get_InventoryBag().getInventoryBag().forEach(x -> System.out.println(x));
    }
}
