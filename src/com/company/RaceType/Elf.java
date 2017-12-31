package com.company.RaceType;

import com.company.RaceType.Stats.AttributeEnum;

public class Elf extends Race {

    public Elf(int str, int dex, int con, int inte, int wis, int chari){
        super(str,dex,con,inte,wis,chari);
    }

    @Override
    public void specialty(){
        attributeStats.get(AttributeEnum.Attribute.Dexterity).increaseBaseValue(2);
        attributeStats.get(AttributeEnum.Attribute.Dexterity).getFinalValue();
    }
}
