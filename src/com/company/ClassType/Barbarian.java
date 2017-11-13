package com.company.ClassType;

import com.company.RaceType.Race;

public class Barbarian extends ClassRole {

    private static final int INCREMENT_STATS = 4;
    private static final int MULTIPLIER = 2;
    private static  final int MAXIMUM = 100;

    public Barbarian(){
        this(INCREMENT_STATS,MULTIPLIER);
    }
    public Barbarian(int increment, int multiplier){
        super(increment,multiplier);
        this.maximum_resource = MAXIMUM;
        this.current_resource = 0;
    }

    @Override
    public void attack(Race player){
        setCurrent_resource(10);
        player.setCurrent_Health(player.getCurrent_Health() - this.strength*2);
    }

    //The purpose of this code is due to the fact that Barbarian will have a static resource and  can not be changed.
    //So when this function is called and given an integer, it will still be set to 100.
    @Override
    public void setMaximum_resource(int maximum_resource){
        this.maximum_resource = MAXIMUM;
    }
}
