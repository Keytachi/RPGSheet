package com.company.RaceType;

import com.company.CharacterPanel.CharacterInformation;
import com.company.RaceType.Stats.AttributeEnum.Attribute;
import com.company.RaceType.Stats.AttributeEnum.AttributeModify;
import com.company.RaceType.Stats.ModifierStats;

import java.util.HashMap;
import java.util.Map;

public abstract class Race {


    HashMap<Attribute,CharacterInformation> attributeMap;
    HashMap<AttributeModify,ModifierStats> modifyMap;



    public Race(int str, int dex, int con, int inte, int wis, int chari){
        this.attributeMap = new HashMap<Attribute,CharacterInformation>(){
            {
                put(Attribute.Strength, new CharacterInformation(str));
                put(Attribute.Dexterity, new CharacterInformation(dex));
                put(Attribute.Constitution, new CharacterInformation(con));
                put(Attribute.Intelligence, new CharacterInformation(inte));
                put(Attribute.Wisdom, new CharacterInformation(wis));
                put(Attribute.Charisma, new CharacterInformation(chari));
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

    public HashMap<Attribute, CharacterInformation> getAttributeMap() {
        return attributeMap;
    }
    public HashMap<AttributeModify, ModifierStats> getModifyMap() {
        return modifyMap;
    }


    /**
     * Use this for only when looking for the specific stats.
     */
    public CharacterInformation getBaseStats(Attribute attribute){
        return this.attributeMap.get(attribute);
    }
    public ModifierStats getModifierStats(AttributeModify modifier){
        return this.modifyMap.get(modifier);
    }

    public abstract void specialty();
}
