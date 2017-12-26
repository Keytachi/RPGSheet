package com.company.Items.Equipment.Weapon;

/**
 * Created by ble on 12/26/2017.
 */

public class Weapon_Enum {

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
        LIGHT{
            public String toString(){ return "Light";}
        },
        FINESSES{
            public String toString(){ return "Finesse";}
        },
        THROWN{
            public String toString() { return "Thrown";}
            public void setMinRange(int min_Range){
                this.min_Range = min_Range;
            }
            public void setMaxRange(int max_Range){
                this.max_Range = max_Range;
            }
        },
        VERSATILE{
            public String toString() { return "Versatile";}
            public void setModify(int modify){
                this.modify = modify;
            }
        },
        HEAVY{
            public String toString() { return "Heavy";}
        },
        NONE;

        public int min_Range;
        public int max_Range;
        public int modify;
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

}
