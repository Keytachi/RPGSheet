package com.company.ClassType;

import com.company.RaceType.Race;
import com.company.Util.dice;

public class Mage extends ClassRole {


    public Mage(){
        super(100, 100, new dice(6));
    }

    @Override
    public void attack(Race player){

    }

    @Override
    public String toString(){
        return "Wizard";
    }


    public void classSpecial(){

    }
}
