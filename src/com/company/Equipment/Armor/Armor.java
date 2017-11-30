package com.company.Equipment.Armor;

import com.company.Equipment.Equipment;
import com.company.PlayerCharacter;
import com.company.RaceType.Race;

public abstract class Armor extends Equipment {

    protected int armor;

    public Armor(String name, int cost, int weight, int armor) {
        super(name, cost, weight);
        this.armor = armor;
    }

    public int get_Armor(){
        return armor;
    }
    public int get_Armor(PlayerCharacter person){
        return person.getRace().getDex_Modifier();
    }

    public void requirement(PlayerCharacter person){
    }
}
