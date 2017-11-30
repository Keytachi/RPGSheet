package com.company.ClassType;

import com.company.PlayerCharacter;
import com.company.RaceType.Race;
import com.company.Util.dice;

import java.util.ArrayList;

public abstract class ClassRole{

    //TODO: Edit this when creating the spell class.
    private ArrayList<Object> spellList = new ArrayList<>();
    private ArrayList<Object> buffList = new ArrayList<>();
    private ArrayList<Object> debuffList = new ArrayList<>();

    protected String[] choices = new String[]{};

    protected int maximum_resource;
    protected int current_resource;
    protected dice hitDie;

    public ClassRole(int maximum_resource, int current_resource, dice hitDie){
        this.maximum_resource = maximum_resource;
        this.current_resource = current_resource;
        this.hitDie = hitDie;
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

    public abstract void classSpecial(PlayerCharacter person);
    public abstract int armor_Proficiency(PlayerCharacter person);
    public String[] getChoices(){
        return this.choices;
    }
}
