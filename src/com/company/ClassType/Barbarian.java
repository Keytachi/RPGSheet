package com.company.ClassType;
import com.company.Equipment.Armor.Armor;
import com.company.Equipment.Armor.Naked;
import com.company.PlayerCharacter;
import com.company.RaceType.Race;
import com.company.Util.dice;

public class Barbarian extends ClassRole {

    private static  final int MAXIMUM = 100;

    public Barbarian(){
        super(MAXIMUM, 0, new dice(12));
    }

    @Override
    public void attack(Race player){

    }
    @Override
    public String toString(){
       return "Barbarian";
    }
    @Override
    public void classSpecial(com.company.PlayerCharacter person){
        unArmored_Defense(person);
    }

    public int unArmored_Defense(PlayerCharacter person) {
        if(person.getArmorEquipment().get(PlayerCharacter.GearSlot.ARMOR) instanceof Naked){
            return person.setArmor_Amount() + person.getRace().getCons_Modifier();
        }
        return 0;
    }

    @Override
    public int armor_Proficiency(PlayerCharacter person){
        return 0;
    }
}
