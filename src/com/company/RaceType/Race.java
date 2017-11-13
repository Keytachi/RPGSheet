package com.company.RaceType;

import com.company.ClassType.ClassRole;
import com.company.Entity;

public abstract class Race extends Entity {

    private String name;
    private ClassRole role;

    private int current_Health;
    private int maximum_Health;


    public Race(String name, int increment_stats, int multiplier, ClassRole role){
        this.name = name;
        this.role = role;

        this.agility = combine_Stats(randomize_Stats(increment_stats,multiplier),this.role.getAgility());
        this.intellect = combine_Stats(randomize_Stats(increment_stats,multiplier),this.role.getIntellect());
        this.strength = combine_Stats(randomize_Stats(increment_stats,multiplier),this.role.getStrength());
        this.stamina = combine_Stats(randomize_Stats(increment_stats,multiplier),this.role.getStamina());

        this.maximum_Health = this.stamina * 10;
        this.current_Health = this.maximum_Health;

        this.role.setMaximum_resource(this.intellect*5);

    }

    public String getName() {
        return name;
    }

    public int getCurrent_Health() {
        return current_Health;
    }

    public void setCurrent_Health(int current_Health) {
        this.current_Health = current_Health;
        if(this.current_Health > this.maximum_Health){
            this.current_Health = this.maximum_Health;
        }
    }

    public int getMaximum_Health() {
        return maximum_Health;
    }

    public void setMaximum_Health(int maximum_Health) {
        this.maximum_Health = maximum_Health;
    }

    public ClassRole getRole() {
        return role;
    }

    private int combine_Stats(int source1, int source2){
        return source1 + source2;
    }

    private int remove_Stats(int source1, int source2){
        return source1 - source2;
    }

    public abstract void specialty();
}
