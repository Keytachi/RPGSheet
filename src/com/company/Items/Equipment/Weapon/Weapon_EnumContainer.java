package com.company.Items.Equipment.Weapon;

/**
 * Created by ble on 12/26/2017.
 */

public class Weapon_EnumContainer {

    public enum Weapon_Category{
        SIMPLE,
        MARTIAL
    }

    public enum Weapon_Type{
        SWORD,
        KNIFE,
        AXE,
        MACE,
        HAMMER,
        STAFF,
        FIST,
        BOW,
        CROSSBOW,
        SHIELD
    }

    public enum Properties{
        LIGHT("Light"),
        FINESSES("Finesses"),
        VERSATILE("Versatile"),
        HEAVY("Heavy"),
        NONE("None");
        public String name;
        Properties(String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return this.name;
        }
    }

    public enum Hand_Req{
        ONEHAND,
        TWOHAND
    }

    public enum Attack_Type{
        SLASHING,
        BLUDGEONING,
        PIERCING
    }

    public enum Amunition_Type {

        BULLETS,
        ARROW,
        BOLTS
    }

}
