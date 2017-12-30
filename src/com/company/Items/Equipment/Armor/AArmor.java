package com.company.Items.Equipment.Armor;

import com.company.Items.Equipment.Item;
import com.company.Character.PlayerCharacter;

/**
 * Created by ble on 12/22/2017.
 */

public abstract class AArmor extends Item implements IArmor {

    protected int armor;
    protected boolean equipped;

    public AArmor(int armor, int cost, int weight, String name) {
        super(name,weight,cost,false, true);
        this.armor = armor;
    }

    @Override
    public int get_Armor(PlayerCharacter person){
        return armor;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    public void get_Requirement(PlayerCharacter person){
    }
}
