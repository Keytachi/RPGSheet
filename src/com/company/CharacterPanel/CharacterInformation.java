package com.company.CharacterPanel;

import com.company.Spell.Effect;

import java.util.HashMap;

public class CharacterInformation {

    protected HashMap<String, Effect> tempBuff;
    protected int baseValue;
    protected int finalValue;

    public CharacterInformation(int baseValue){
        tempBuff = new HashMap<>();
        this.baseValue = baseValue;
        update();
    }

    public void increaseBaseValue(int value){
        baseValue += value;
    }

    public int getFinalValue(){
        return calculateFinalValue();
    }
    public int getBaseValue(){
        return baseValue;
    }

    public void update(){
        calculateFinalValue();
    }

    public void addTempBuff(Effect effect){
        tempBuff.put(effect.getName(),effect);
    }

    public void removeTempBuff(String effectName){
        if(tempBuff.keySet().contains(effectName)) {
            tempBuff.remove(tempBuff.remove(effectName));
        }
    }

    private int calculateFinalValue(){
        finalValue = baseValue;
        tempBuff.keySet().forEach(x-> finalValue += tempBuff.get(x).getStatsRate());
        return finalValue;
    }
}
