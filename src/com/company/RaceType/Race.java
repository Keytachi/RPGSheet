package com.company.RaceType;

import com.company.RaceType.Stats.AttributeEnum.Attribute;
import com.company.RaceType.Stats.AttributeEnum.AttributeModify;
import com.company.RaceType.Stats.BaseStats;
import com.company.RaceType.Stats.ModifierStats;
import com.company.Util.dice;

import java.util.HashMap;

public abstract class Race {


    HashMap<Attribute,BaseStats> attributeMap;
    HashMap<AttributeModify,ModifierStats> modifyMap;
    protected int walking_Speed;


    public Race(int str, int dex, int con, int inte, int wis, int chari){
        this.attributeMap = new HashMap<Attribute,BaseStats>(){
            {
                put(Attribute.Strength, new BaseStats(str));
                put(Attribute.Dexterity, new BaseStats(dex));
                put(Attribute.Constitution, new BaseStats(con));
                put(Attribute.Intelligence, new BaseStats(inte));
                put(Attribute.Wisdom, new BaseStats(wis));
                put(Attribute.Charisma, new BaseStats(chari));
            }
        };

        this.modifyMap = new HashMap<AttributeModify,ModifierStats>(){
            {
                put(AttributeModify.Str_Modifier, new ModifierStats(attributeMap.get(Attribute.Strength)));
                put(AttributeModify.Dex_Modifier, new ModifierStats(attributeMap.get(Attribute.Dexterity)));
                put(AttributeModify.Con_Modifier, new ModifierStats(attributeMap.get(Attribute.Constitution)));
                put(AttributeModify.Int_Modifier, new ModifierStats(attributeMap.get(Attribute.Intelligence)));
                put(AttributeModify.Wis_Modifier, new ModifierStats(attributeMap.get(Attribute.Wisdom)));
                put(AttributeModify.Cha_Modifier, new ModifierStats(attributeMap.get(Attribute.Charisma)));
            }
        };
    }

    public HashMap<Attribute, BaseStats> getAttributeMap() {
        return attributeMap;
    }

    public HashMap<AttributeModify, ModifierStats> getModifyMap() {
        return modifyMap;
    }

    /**
     * Use this for only when looking for the specific stats.
     */
    public BaseStats getBaseStats(Attribute attribute){
        return this.attributeMap.get(attribute);
    }
    public ModifierStats getModifierStats(AttributeModify modifier){
        return this.modifyMap.get(modifier);
    }


    public void displayStats(){
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("Character Stats");
        System.out.println("+++++++++++++++++++++++++++++++");
        for(Attribute attribute : attributeMap.keySet()){
            System.out.println(attribute + " : " + attributeMap.get(attribute).getFinalStats());
        }
        for(AttributeModify modify : modifyMap.keySet()){
            System.out.println(modify + " : " + modifyMap.get(modify).getFinalModifier());
        }
        System.out.println(" ");
    }

    public int getWalking_Speed() {
        return walking_Speed;
    }

    public void setWalking_Speed(int walking_Speed) {
        this.walking_Speed = walking_Speed;
    }

    public abstract void specialty();
}
