package com.company.CharacterPanel;

public class Health extends Stats {

    public Health(int maximum_Health){
        super(maximum_Health);
    }

    public void addHealth(int value){
        this.baseValue += value;
    }
    public void setHealth(int value){
        this.baseValue = value;
    }

    @Override
    protected int calculateFinalValue(){
        setHealth(super.calculateFinalValue());
        return this.finalValue;
    }
}
