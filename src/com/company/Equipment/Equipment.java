package com.company.Equipment;

public abstract class Equipment {

    private int weight;
    private int cost;
    private String name;

    public Equipment(String name, int cost, int weight) {
        this.weight = weight;
        this.cost = cost;
        this.name = name;
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
