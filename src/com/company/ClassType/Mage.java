package com.company.ClassType;

import com.company.RaceType.Race;

public class Mage extends ClassRole {
    private static final int INCREMENT_STATS = 4;
    private static final int MULTIPLIER = 2;

    public Mage(){
        this(INCREMENT_STATS,MULTIPLIER);
    }
    public Mage(int increment, int multiplier){
        super(increment,multiplier);
    }

    @Override
    public void attack(Race player){
        player.setCurrent_Health(player.getCurrent_Health() - this.strength*2);
    }
}
