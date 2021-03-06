package com.company.RaceType;


import com.company.RaceType.Stats.AttributeEnum.Attribute;
import com.company.Util.dice;

public class Human extends Race {


    public Human(int str, int dex, int con, int inte, int wis, int chari){
        super(str,dex,con,inte,wis,chari);
        specialty();
    }

    public Human(){
        this(dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4), dice.rollStats(6,4),
                dice.rollStats(6,4),dice.rollStats(6,4));
    }

    @Override
    public void specialty(){
        for(Attribute attribute : attributeStats.keySet()){
            attributeStats.get(attribute).increaseBaseValue(1);
            attributeStats.get(attribute).getFinalValue();
        }
    }
}
