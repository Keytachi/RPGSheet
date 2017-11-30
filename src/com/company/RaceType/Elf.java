package com.company.RaceType;

public class Elf extends Race {

    public Elf(String name){
        super(name);
        specialty();
        setModify();
    }

    @Override
    public void specialty(){
        this.setDexterity(this.getDexterity()+2);
    }
}
