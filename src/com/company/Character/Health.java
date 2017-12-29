package com.company.Character;

import com.company.Spell.Effect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ble on 12/26/2017.
 */

public class Health {

    private List<Effect> tempHealthIncrease;
    private List<Effect> tempHealing;

    private int current_Health;
    private int maximum_Health;
    private int final_Current_Health;
    private int final_Maximum_Health;

    public Health(int maximum_Health){
        this.maximum_Health = maximum_Health;
        this.current_Health = this.maximum_Health;
        tempHealthIncrease = new ArrayList<>();
    }

    public void addTempHealth(List<Effect> tempList, Effect effect){
        tempList.add(effect);
    }

    public void removeTempHealth(List<Effect> tempList, Effect effect){ tempList.remove(effect); }

    public void setFinal_Current_Health() {
        if(calculateFinalCurrent_Health() > getFinal_Maximum_Health()){
            this.final_Current_Health = this.final_Maximum_Health;
        }else{
            calculateFinalCurrent_Health();
        }
    }

    public void setFinal_Maximum_Health(){
        calculateFinalMaximum_Health();
    }

    public int getFinal_Current_Health() { return this.final_Current_Health; }
    public int getFinal_Maximum_Health() { return this.final_Maximum_Health; }

    public void setCurrent_Health(){ this.current_Health = maximum_Health; }
    public void setMaximum_Health(int maximum_Health) {
        this.maximum_Health += maximum_Health;
    }


    private int calculateFinalCurrent_Health(){
        this.final_Current_Health = current_Health;
        tempHealing.forEach(x-> this.final_Current_Health += x.getStatsRate());
        return this.final_Current_Health;
    }

    private int calculateFinalMaximum_Health(){
        this.final_Maximum_Health = maximum_Health;
        tempHealthIncrease.forEach(x -> this.final_Maximum_Health += x.getStatsRate());
        return final_Maximum_Health;
    }
}
