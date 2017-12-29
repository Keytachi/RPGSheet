package com.company.Spell;

import com.company.RaceType.Stats.AttributeEnum;

/**
 * Created by ble on 12/29/2017.
 */

public class Buff extends Effect {



    public Buff(int id,String name,Effects_Type effect_type, int statsEffect,
                AttributeEnum.Attribute target_Attribute,int duration, Target_Type target_type) {
        super(id,name,effect_type, statsEffect, duration,target_type);
        this.target_Attribute = target_Attribute;
    }



}
