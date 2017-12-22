package com.company.Items.Equipment;

public abstract class Item {

    private int weight;
    private int cost;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public int getWeight(){
        return weight;
    }
    public String toString(){
        return name;
    }
    public String getName() {
        return name;
    }
}
