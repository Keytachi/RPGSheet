package com.company.RaceType;

import com.company.ClassType.ClassRole;

public class High_Elf extends Elf {

    public High_Elf(String name, ClassRole role) {
        super(name, role);
    }

    //TODO: Figure out if this sub-race gets the special from the main-race.
    @Override
    public void specialty(){
        this.setIntelligence(this.getIntelligence()+1);
    }
}
