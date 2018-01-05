package com.company.Items.Equipment.Weapon;

/**
 * Created by ble on 12/26/2017.
 */

public class Weapon_EnumContainer {

    public enum Weapon_Category{
        SIMPLE("Simple"),
        MARTIAL("Martial");

        String name;
        Weapon_Category(String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return name;
        }
    }

    public enum Weapon_Type{
        SWORD("Sword"),
        KNIFE("Knife"),
        AXE("Axe"),
        MACE("Mace"),
        HAMMER("Hammer"),
        STAFF("Staff"),
        FIST("Fist"),
        BOW("Bow"),
        CROSSBOW("Crossbow"),
        SHIELD("Shield");

        String name;
        Weapon_Type(String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return name;
        }
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
        ONEHAND("One-Hand"),
        TWOHAND("Two-Hand");

        String name;
        Hand_Req(String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return name;
        }
    }

    public enum Attack_Type{
        SLASHING("Slashing"),
        BLUDGEONING("Bludgeoning"),
        PIERCING("Piercing");

        String name;

        Attack_Type(String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return name;
        }
    }

    public enum Amunition_Type {

        BULLETS,
        ARROW,
        BOLTS
    }

}
