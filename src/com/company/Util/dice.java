package com.company.Util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class dice {

    private int sides;
    private static final int minSide = 3;

    public dice(){
        this(minSide);
    }
    public dice(int sides) {
        if(sides < minSide) sides = minSide;
        this.sides = sides;
    }

    public int roll(){
        return roll(sides);
    }

    public static int roll(int numSide){
        return (int)(Math.random()*numSide+1);
    }

    public static int rollStats(int numSided, int numDice){
        if(numDice < 1) return 0;
        Integer[] diceArray = new Integer[numDice];
        int sum = 0;
        for (int d = 0; d < numDice; d++){
            diceArray[d] = roll(numSided);
        }
        Arrays.sort(diceArray,Collections.reverseOrder());
        for (int d = 0; d < 3; d++){
            sum += diceArray[d];
        }
        return sum;
    }



    @Override
    public String toString(){
        return "D" + sides + " - " + sides + " sided die";
    }
}
