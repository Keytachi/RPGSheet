package com.company.ClassType;

import com.company.Entity;
import com.company.RaceType.Race;

import java.util.ArrayList;

public abstract class ClassRole extends Entity {

    //TODO: Edit this when creating the spell class.
    private ArrayList<Object> spellList = new ArrayList<>();
    private ArrayList<Object> buffList = new ArrayList<>();
    private ArrayList<Object> debuffList = new ArrayList<>();

    protected String[] choices = new String[]{};

    protected int maximum_resource;
    protected int current_resource;

    public ClassRole(int increment_stats, int multiplier){
        String[] choices = new String[] {"Attack", "Spells", "Items", "Run"};
        this.agility = randomize_Stats(increment_stats,multiplier);
        this.intellect = randomize_Stats(increment_stats,multiplier);
        this.strength = randomize_Stats(increment_stats,multiplier);
        this.stamina = randomize_Stats(increment_stats,multiplier);
        this.choices = choices;
    }

    //TODO: Edit this implementation in other subclasses to use weapons * strength.
    public abstract void attack(Race target);

    public int getMaximum_resource() {
        return maximum_resource;
    }

    public void setMaximum_resource(int maximum_resource) {
        this.maximum_resource = maximum_resource;
    }

    public int getCurrent_resource() {
        return current_resource;
    }

    public void setCurrent_resource(int current_resource) {
        this.current_resource += current_resource;
        if(this.current_resource > this.maximum_resource){
            this.current_resource = this.maximum_resource;
        }
    }

    public String[] getChoices(){
        return this.choices;
    }
}
