package com.company.ClassType;

import com.company.Spell.SpellBook;
import com.company.Util.EnumContainer;
import com.company.Util.dice;

import java.util.Map;

public class Wizard extends ClassRole {


    private SpellBook spellBook;

    public Wizard(){
        super(new dice(6));
        this.spellBook = new SpellBook();
        addSpellLevel1();
    }

    public void addSpellLevel1(){

    }

    @Override
    public String toString(){
        return "Wizard";
    }

    @Override
    public int get_ArmorProficiency(Map gearEquipment, EnumContainer.GearSlot gearSlot){
        return 0;
    }
}
