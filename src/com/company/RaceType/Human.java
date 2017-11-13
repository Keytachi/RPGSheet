package com.company.RaceType;

import com.company.ClassType.ClassRole;

public class Human extends Race{

    private static final int MULTIPLIER = 1;
    private static final int INCREMENT_STATS = 2;

    public Human(String name, ClassRole role){
        super(name, MULTIPLIER, INCREMENT_STATS, role);
    }

    @Override
    public void specialty(){

    }
}
