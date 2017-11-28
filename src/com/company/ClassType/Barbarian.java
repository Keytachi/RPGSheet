package com.company.ClassType;
import com.company.RaceType.Race;
import com.company.Util.dice;

public class Barbarian extends ClassRole {

    private static  final int MAXIMUM = 100;

    public Barbarian(){
        super(MAXIMUM, 0, new dice(12));
    }

    @Override
    public void attack(Race player){

    }
    @Override
    public String toString(){
       return "Barbarian";
    }
    @Override
    public void classSpecial(){
    }
}
