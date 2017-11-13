package com.company.RaceType;

import com.company.ClassType.ClassRole;

public class Elf extends Race {

    private static final int MULTIPLIER = 2;
    private static final int INCREMENT_STATS = 2;

    public Elf(String name, ClassRole role){
        super(name,MULTIPLIER,INCREMENT_STATS, role);
    }

    @Override
    public void specialty(){

    }
}
