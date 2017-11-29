package com.company;

import com.company.ClassType.Barbarian;
import com.company.ClassType.ClassRole;
import com.company.ClassType.Mage;
import com.company.RaceType.Race;

public class PlayerCharacter {

    private Race race;
    private ClassRole role;

    private int current_Health;
    private int maximum_Health;


    //TODO: Work on this armor part again.
    /**
     *  Idea: Hashmap<String, Armor>
     *  String = Body
     *  Armor = Any instanceof Armor.
     *
     *  Issue: Is it worth using hasmap for 1 item?
     */
    //TODO: Work on this weapon part again.
    /**
     Idea: Hashmap<String, Weapon> or a Map<String,Weapon>
     String = "Left Hand", "Right Hand"
     Weapon = Any instanceof Weapon. Should include shield.

     Issue: Shield is an instanceof an armor class
     */

    
    public PlayerCharacter(Race race, ClassRole role){
        this.race = race;
        this.role = role;
        setHealth();

    }

    public void setHealth(){
        if (this.role instanceof Barbarian){
            this.maximum_Health = 12 + this.race.getCons_Modifier();
            this.current_Health = this.maximum_Health;
        }
        else if (this.role instanceof Mage){
            this.maximum_Health = 8 + this.race.getCons_Modifier();
            this.current_Health = this.maximum_Health;
        }
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
}
