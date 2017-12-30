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
        for(AttributeEnum.Attribute attribute : host.get_Race().getAttributeMap().keySet()){
            System.out.println(attribute +  " : " + host.get_Race().getBaseStats(attribute).getFinalValue());
        }
        System.out.println("");
    }

    public static void displayCharacterModifier(PlayerCharacter host){
        header(host.getName() + "'s Modifier");
        for(AttributeEnum.AttributeModify modify : host.get_Race().getModifyMap().keySet()){
            System.out.println(modify + " : " + host.get_Race().getModifierStats(modify).getFinalModifier());
        }
        System.out.println("");
    }

    public static void displayGear(PlayerCharacter host){
        header(host.getName() + "'s Equipment");
        for (EnumContainer.GearSlot hands : EnumContainer.weapon_Slot){
            System.out.println(hands + " : " + host.getGear_Equipment().getWeapon(hands));
        }
        System.out.println(EnumContainer.GearSlot.ARMOR + " : " + host.getGear_Equipment().getArmor(EnumContainer.GearSlot.ARMOR));
        System.out.println("");
    }

    public static void displayInventory(PlayerCharacter host){
        header(host.getName() + "'s Inventory");
        for(Item items: host.get_InventoryBag().getInventoryBag()){
            System.out.println(items);
        }
    }
}
