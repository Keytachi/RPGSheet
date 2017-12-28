package com.company.RaceType;

import com.company.ClassType.ClassRole;
import com.company.RaceType.Elf;
import com.company.RaceType.Stats.AttributeEnum;
import com.company.Util.dice;


public class High_Elf extends Elf {

    public High_Elf(int str, int dex, int con, int inte, int wis, int chari){
        super(str,dex,con,inte,wis,chari);
        specialty();
    }

    public High_Elf() {
        this(dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4),dice.rollStats(6,4));
    }

    @Override
    public void specialty(){
        super.specialty();
        this.attributeMap.get(AttributeEnum.Attribute.Intelligence).setBaseStats(1);
        this.attributeMap.get(AttributeEnum.Attribute.Intelligence).calculateFinalStats();
    }
}
