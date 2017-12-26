package com.company.Character;

import java.util.ArrayList;

/**
 * Created by ble on 12/26/2017.
 */

public class Health {

    private ArrayList<Integer> additiveHealth;

    private int current_Health;
    private int maximum_Health;

    public Health(int maximum_Health){
        this.maximum_Health = maximum_Health;
        this.current_Health = this.maximum_Health;
    }

    public void addAdditiveHealth(int health){
        additiveHealth.add(health);
    }

    public void removeAdditiveHealth(int health){
        additiveHealth.remove(health);
    }

    public int getCurrent_Health() {
        return current_Health;
    }

    public void setCurrent_Health(int current_Health) {
        this.current_Health += current_Health;
        if(this.current_Health > this.maximum_Health){
            this.current_Health = this.maximum_Health;
        }
    }

    public int getMaximum_Health() {
        return maximum_Health;
    }

    public void setMaximum_Health(int maximum_Health) {
        this.maximum_Health += maximum_Health;
    }

    public int calculateMaximum_Health(){
        additiveHealth.forEach(x -> this.maximum_Health += x.intValue());
        return maximum_Health;
    }
}
