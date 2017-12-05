package com.company;

public abstract class Item {

    private int weight;
    private int cost;
    private String name;

    public Item(int weight, int cost, String name) {
        this.weight = weight;
        this.cost = cost;
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
