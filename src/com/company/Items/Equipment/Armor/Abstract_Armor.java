package com.company.Items.Equipment.Armor;

import com.company.Items.Equipment.Item;
import com.company.PlayerCharacter;

/**
 * Created by ble on 12/22/2017.
 */

public class Abstract_Armor extends Item implements Armor {

    protected int armor;
    protected int cost;
    protected int weight;
    protected boolean equipped;

    public Abstract_Armor(int armor, int cost, int weight, String name) {
        super(name);
        this.armor = armor;
        this.cost = cost;
        this.weight = weight;
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

    @Override
    public boolean isEquipped() {
        return this.equipped;
    }

    @Override
    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public void get_Requirement(PlayerCharacter person){
    }
}
