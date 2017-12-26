package com.company.Character;

import java.util.ArrayList;

/**
 * Created by ble on 12/26/2017.
 */

public class CharacterArmor {
    private ArrayList<Integer> bonusArmor;

    private int armor;

    public CharacterArmor(int armor) {
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor += armor;
    }

    public void addBonusArmor(int bonusArmors){
        bonusArmor.add(bonusArmors);
    }

    public void removeBonusArmor(int bonusArmors){
        bonusArmor.remove(bonusArmors);
    }
}
