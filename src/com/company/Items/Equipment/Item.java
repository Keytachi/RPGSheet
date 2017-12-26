package com.company.Items.Equipment;

public abstract class Item {

    protected int weight;
    protected int cost;
    private String name;
    protected boolean useable;
    protected boolean equipable;

    public Item(String name, int weight, int cost, boolean useable, boolean equipable) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.useable = useable;
        this.equipable = equipable;
    }

    public int getCost(){ return cost; }
    public int getWeight(){
        return weight;
    }
    public String toString(){
        return name;
    }
    public String getName() {
        return name;
    }
    public boolean getUseable(){ return useable; }
    public boolean getEquipable(){ return equipable; }
}
