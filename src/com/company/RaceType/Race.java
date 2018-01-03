package com.company.RaceType;

import com.company.CharacterPanel.Stats;
import com.company.RaceType.Misc.Height;
import com.company.RaceType.Stats.AttributeEnum;
import com.company.RaceType.Stats.AttributeEnum.Attribute;
import com.company.RaceType.Stats.AttributeEnum.AttributeModify;
import com.company.RaceType.Stats.ModifierStats;

import java.util.HashMap;

public abstract class Race {


    HashMap<Attribute,Stats> attributeStats;
    HashMap<AttributeModify,ModifierStats> modifyStats;
    protected Height height;



    public Race(int str, int dex, int con, int inte, int wis, int chari, Height height){
        this.attributeStats = new HashMap<Attribute,Stats>(){
            {
                put(Attribute.Strength, new Stats(str));
                put(Attribute.Dexterity, new Stats(dex));
                put(Attribute.Constitution, new Stats(con));
                put(Attribute.Intelligence, new Stats(inte));
                put(Attribute.Wisdom, new Stats(wis));
                put(Attribute.Charisma, new Stats(chari));
            }
        };

        this.modifyStats = new HashMap<AttributeModify,ModifierStats>(){
            {
                put(AttributeModify.Str_Modifier, new ModifierStats(attributeStats.get(Attribute.Strength)));
                put(AttributeModify.Dex_Modifier, new ModifierStats(attributeStats.get(Attribute.Dexterity)));
                put(AttributeModify.Con_Modifier, new ModifierStats(attributeStats.get(Attribute.Constitution)));
                put(AttributeModify.Int_Modifier, new ModifierStats(attributeStats.get(Attribute.Intelligence)));
                put(AttributeModify.Wis_Modifier, new ModifierStats(attributeStats.get(Attribute.Wisdom)));
                put(AttributeModify.Cha_Modifier, new ModifierStats(attributeStats.get(Attribute.Charisma)));
            }
        };

        this.height = height;
    }

    public HashMap<Attribute, Stats> getAttributeStats() {
        return attributeStats;
    }
    public HashMap<AttributeModify, ModifierStats> getModifyStats() {
        return modifyStats;
    }
    public Height getHeight(){
        return height;
    }

    /**
     * Use this for only when looking for the specific stats.
     */
    public int getAttributeStatsValue(Attribute attribute){
        return this.attributeStats.get(attribute).getFinalValue();
    }
    public int getModifyStatsValue(AttributeModify modifier){
        return this.modifyStats.get(modifier).getFinalModifier();
    }

    public abstract void specialty();
}
