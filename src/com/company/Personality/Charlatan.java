package com.company.Personality;

import java.util.HashMap;

public class Charlatan extends Personality {

    public Charlatan(){
        setPersonality();
        setIdeal();
        setBond();
        setFlaw();
        this.traits = new HashMap<String,String>(){{
            traits.put("Personality", getTrait(personalityTraits));
            traits.put("Ideal", getTrait(idealTraits));
            traits.put("Bond", getTrait(bondTraits));
            traits.put("Flaw", getTrait(flawTraits));
        }};
    }

    public Charlatan(int personalityRoll, int idealRoll, int bondRoll, int flawRoll){
        setPersonality();
        setIdeal();
        setBond();
        setFlaw();
        this.traits = new HashMap<String,String>(){{
            traits.put("Personality", getTrait(personalityTraits,personalityRoll));
            traits.put("Ideal", getTrait(idealTraits,idealRoll));
            traits.put("Bond", getTrait(bondTraits,bondRoll));
            traits.put("Flaw", getTrait(flawTraits,flawRoll));
        }};
    }


    private void setPersonality(){
        this.personalityTraits = new HashMap<Integer,String>(){
            {
                personalityTraits.put(1, "I fall in and out of love easily, and am always pursuing " +
                        "someone.");
                personalityTraits.put(2,"I have a joke for every occasion, especially occasions " +
                        "where humor is inappropriate");
                personalityTraits.put(3,"Flattery is my preferred trick for getting what I want.");
                personalityTraits.put(4," I’m a born gambler who can't resist taking a risk for a " +
                        "potential payoff. ");
                personalityTraits.put(5,"I lie about almost everything, even when there’s no good reason to.");
                personalityTraits.put(6,"Sarcasm and insults are my weapons of choice.");
                personalityTraits.put(7, "I keep multiple holy symbols on me and invoke " +
                        "whatever deity might come in useful at any given moment.");
                personalityTraits.put(8, "I pocket anything I see that might have some value.");
            }
        };
    }

    private void setIdeal(){
        this.idealTraits = new HashMap<Integer,String>(){
            {
                idealTraits.put(1, "Independence. I am a free spirit— no one tells me what " +
                        "to do. (Chaotic)");
                idealTraits.put(2, "Fairness. I never target people who can’t afford to lose " +
                        "a few coins. (Lawful)");
                idealTraits.put(3, "Charity. I distribute the money I acquire to the people " +
                        "who really need it. (Good)");
                idealTraits.put(4, "Creativity. I never run the same con twice. (Chaotic)");
                idealTraits.put(5, "Friendship. Material goods come and go. Bonds of " +
                        "friendship last forever. (Good)");
                idealTraits.put(6, "Aspiration. I’m determined to make something " +
                        "of myself. (Any)");
            }
        };
    }

    private void setBond(){
        this.bondTraits = new HashMap<Integer, String>(){
            {
                bondTraits.put(1, "I fleeced the wrong person and must work to ensure that this individual never crosses paths with me or " +
                        "those I care about");
                bondTraits.put(2, "I owe everything to my mentor— a horrible person " +
                        "who’s probably rotting in jail somewhere.");
                bondTraits.put(3, "Somewhere out there, I have a child who doesn't " +
                        "know me. I’m making the world better for him or her");
                bondTraits.put(4, "I come from a noble family, and one day I’ll reclaim my " +
                        "lands and title from those who stole them from me.");
                bondTraits.put(5, "A powerful person killed someone I love. Some day " +
                        "soon, I’ll have my revenge.");
                bondTraits.put(6, "I swindled and ruined a person who didn't deserve it.  I " +
                        "seek to atone for my misdeeds but might never be able " +
                        "to forgive myself.");
            }
        };
    }

    private void setFlaw(){
        this.flawTraits = new HashMap<Integer, String>(){{

            flawTraits.put(1, "I can’t resist a pretty face." );
            flawTraits.put(2, "I'm always in debt. I spend my ill-gotten gains on decadent luxuries faster than I bring them in.");
            flawTraits.put(3, "I’m convinced that no one could ever fool me the way " +
                    "I fool others.");
            flawTraits.put(4, "I’m too greedy for my own good. I can’t resist taking a " +
                    "risk if there’s money involved. ");
            flawTraits.put(5, "I can’t resist swindling people who are more powerful than me.");
            flawTraits.put(6, "I hate to admit it and will hate myself for it, but I'll run " +
                    "and preserve my own hide if the going gets tough.");
        }};
    }
}
