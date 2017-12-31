package com.company.CharacterPanel;

/**
 * Created by ble on 12/30/2017.
 */

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
        return getFinalValue();

    }
}
