package com.company;

public abstract class Entity {

    protected int agility;
    protected int intellect;
    protected int stamina;
    protected int strength;

    public int randomize_Stats(int increment_stats,int multiplier){
        return (int)(Math.random()*(increment_stats*multiplier)+1);
    }
    public int getAgility() {
        return agility;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

}
