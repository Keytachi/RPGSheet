package com.company.RaceType;

import com.company.ClassType.ClassRole;

public class Elf extends Race {

    public Elf(String name){
        super(name);
        specialty();
        setModify();
    }

    @Override
    public void specialty(){
        this.setDexterity(this.getDexterity()+2);
        this.walking_Speed = 30;
    }
}
