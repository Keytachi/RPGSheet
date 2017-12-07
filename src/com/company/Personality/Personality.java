package com.company.Personality;

import com.company.Util.dice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Personality {

    //Set<String> traitsValue = new HashSet<>(Arrays.asList("Personality","Ideal","Bond","Flaw"));
    protected Map<String, String> traits;
    protected Map<Integer,String> personalityTraits;
    protected Map<Integer,String> idealTraits;
    protected Map<Integer, String> bondTraits;
    protected Map<Integer, String> flawTraits;


    protected String getTrait(Map<Integer,String> trait){
        dice diceRoller = new dice(trait.size());
        return trait.get(diceRoller.roll());
    }
}
