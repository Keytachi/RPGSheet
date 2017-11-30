package com.company.ClassType;
import com.company.Equipment.Armor.Armor;
import com.company.Equipment.Armor.Light_Armor.LightArmor;
import com.company.Equipment.Armor.Medium_Armor.MediumArmor;
import com.company.Equipment.Armor.Naked;
import com.company.Equipment.Weapon.Club;
import com.company.Equipment.Weapon.Shield;
import com.company.Equipment.Weapon.Weapon;
import com.company.PlayerCharacter;
import com.company.RaceType.Race;
import com.company.Util.Util;
import com.company.Util.dice;

import java.util.Map;

public class Barbarian extends ClassRole {

    private int rage;
    private Class<Armor> armorProficiency[] = new Class[]{
            LightArmor.class,
            MediumArmor.class
    };

    private Enum<PlayerCharacter.GearSlot> weaponslots[] = new Enum[]{
            PlayerCharacter.GearSlot.RHAND,
            PlayerCharacter.GearSlot.LHAND
    };

    private Class<Weapon> weaponProficiency[] = new Class[]{
            Shield.class,
            Club.class
    };

    public Barbarian(){
        super(new dice(12));
        this.rage = setRage();
    }

    @Override
    public void attack(Race player){

    }
    @Override
    public String toString(){
       return "Barbarian";
    }


    public int unArmored_Defense(PlayerCharacter person) {
        if(person.getArmorEquipment().get(PlayerCharacter.GearSlot.ARMOR) instanceof Naked){
            return person.setArmor_Amount() + person.getRace().getCons_Modifier();
        }
        return 0;
    }

    @Override
    public int get_ArmorProficiency(Map gearEquipment, PlayerCharacter.GearSlot gearSlot){
        for(int i = 0; i < armorProficiency.length; i++)
        {
            for(int j = 0; j < weaponslots.length; i++){
                if(Util.gearNameMatch(gearEquipment.get(gearSlot),armorProficiency[i])
                        || Util.gearNameMatch(gearEquipment.get(weaponslots[j]),Shield.class)){
                    return this.proficiency;
                }
            }

        }
        return 0;
    }

    /**@Override
    public int weapon_Proficiency(PlayerCharacter person){
    }**/

    public int setRage() {
        if (level >= 1 && level <= 2){
            return 2;
        }else if (level >= 3 && level <= 5){
            return 3;
        }else if (level >= 6 && level <= 11){
            return 4;
        }else if (level >= 12 && level <= 16){
            return 5;
        }else if (level >= 17  && level <= 19){
            return 6;
        }else if (level == 20){
            return 100;
        }
        return 0;
    }
}
