package com.company.Test_Class;

import com.company.Util.dice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ble on 12/26/2017.
 */

public abstract class Test_Race {
    protected List<BaseStats> baseStats = new ArrayList<>();
    protected List<ModifierStats> modifyStats = new ArrayList<>();


    protected String[] attributeList =  {"Strength", "Dexterity", "Constitution", "Intelligence",
            "Wisdom", "Charisma"};

    protected String[] modifierList = {"Strength Modifier", "Dexterity Modifier", "Constitution Modifier",
    "Intelligence Modifier", "Wisdom Modifier", "Charisma Modifier"};

    public Test_Race(int str_value, int dex_value, int cons_value, int int_value, int wis_value, int char_value){
        Integer[] valueList = {str_value,dex_value,cons_value,int_value,wis_value,char_value};
        for(int i = 0; i < attributeList.length; i++){
            baseStats.add(new BaseStats(valueList[i],attributeList[i]));
            modifyStats.add(new ModifierStats(modifierList[i],baseStats.get(i)));
        }
    }

    public Test_Race(){
        this(dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4),dice.rollStats(6,4));
    }

    public List<BaseStats> getBaseStats() {
        return baseStats;
    }

    public List<ModifierStats> getModifyStats() {
        return modifyStats;
    }

    public void displayStats(){
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("Character Stats");
        System.out.println("+++++++++++++++++++++++++++++++");
        baseStats.forEach(x -> System.out.println(x.getName() + " : " + x.calculateFinalStats()));
        modifyStats.forEach(x -> System.out.println(x.getName() + " : " + x.getFinalModifier()));
        System.out.println(" ");
    }
}
