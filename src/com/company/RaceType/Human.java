package com.company.RaceType;

public class Human extends Race{


    public Human(String name){
        super(name);
        specialty();
        setModify();
    }

    @Override
    public void specialty(){
        this.setStrength(this.strength+1);
        this.setDexterity(this.dexterity+1);
        this.setConstitution(this.constitution+1);
        this.setIntelligence(this.intelligence+1);
        this.setWisdom(this.wisdom+1);
        this.setCharisma(this.charisma+1);
    }
}
