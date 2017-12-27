package com.company.RaceType.Stats;

public class AttributeEnum {

    public enum Attribute{
        Strength,
        Dexterity,
        Constitution,
        Intelligence,
        Wisdom,
        Charisma
    }

    public enum AttributeModify{
        Str_Modifier{
            @Override
            public String toString() {
                return "Strength Modifier";
            }
        },
        Dex_Modifier{
            @Override
            public String toString() {
                return "Dexterity Modifier";
            }
        },
        Con_Modifier{
            @Override
            public String toString() {
                return  "Constitution Modifier";
            }
        },
        Int_Modifier{
            @Override
            public String toString() {
                return  "Intelligence Modifier";
            }
        },
        Wis_Modifier{
            @Override
            public String toString() {
                return "Wisdom Modifier";
            }
        },
        Cha_Modifier{
            @Override
            public String toString() {
                return "Charisma Modifier";
            }
        },
    }
}
