package com.company;

public abstract class Item {

    private Boolean stackable;
    private int max_Stack;

    public Item(Boolean stackable, int max_Stack) {
        this.stackable = stackable;
        this.max_Stack = max_Stack;
    }

    public Boolean getStackable() {
        return stackable;
    }

    public int getMax_Stack() {
        return max_Stack;
    }
}
