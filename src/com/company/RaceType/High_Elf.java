package com.company.RaceType;

import com.company.RaceType.Misc.Height;
import com.company.RaceType.Stats.AttributeEnum;
import com.company.Util.dice;


public class High_Elf extends Elf {

    public High_Elf(int str, int dex, int con, int inte, int wis, int chari, Height height){
        super(str,dex,con,inte,wis,chari,height);
        specialty();
    }

    public High_Elf() {
        this(dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4),dice.rollStats(6,4),
                new Height(54, 90, 10, 4));
    }

    @Override
    public void specialty(){
        super.specialty();
        attributeStats.get(AttributeEnum.Attribute.Intelligence).increaseBaseValue(1);
        attributeStats.get(AttributeEnum.Attribute.Intelligence).getFinalValue();
    }
}
