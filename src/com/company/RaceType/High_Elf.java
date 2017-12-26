package com.company.RaceType;

import com.company.ClassType.ClassRole;


public class High_Elf extends Elf {

    public High_Elf(String name) {
        super(name);
    }

    @Override
    public void specialty(){
        super.specialty();
        this.setIntelligence(this.getIntelligence()+1);
    }
}
