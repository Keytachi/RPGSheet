package com.company.RaceType;

import com.company.RaceType.Stats.AttributeEnum;

public class Elf extends Race {

    public Elf(int str, int dex, int con, int inte, int wis, int chari){
        super(str,dex,con,inte,wis,chari);
    }

    @Override
    public void specialty(){
        this.attributeMap.get(AttributeEnum.Attribute.Dexterity).setBaseStats(2);
        this.attributeMap.get(AttributeEnum.Attribute.Dexterity).calculateFinalStats();
    }
}
