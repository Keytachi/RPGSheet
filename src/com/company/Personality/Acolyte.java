package com.company.Personality;

import java.util.HashMap;

public class Acolyte extends Personality {

    public Acolyte(){
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

    private void setPersonality(){
        this.personalityTraits = new HashMap<Integer,String>(){
            {
                personalityTraits.put(1, "I idolize a particular hero of my faith, and constantly refer to that "+
                "person's deeds and example.");
                personalityTraits.put(2,"I can find common ground between the fiercest enemies, empathizing" +
                " with them and always working towards peace.");
                personalityTraits.put(3,"I see omens in every event and action. The gods try to speak to us"+
                ", we just need to listen.");
                personalityTraits.put(4,"Nothing can shake my optimistic attitude.");
                personalityTraits.put(5,"I quote (or misquote) sacred texts and proverbs in almost every situations");
                personalityTraits.put(6,"I am tolerate (or intolerant) of other faiths and respect (or condemn) " +
                "the worship of the other gods.");
                personalityTraits.put(7, "I enjoyed find food, drink, and high society among my temple's elite." +
                " Rough living grates on me.");
                personalityTraits.put(8, "I've spent so long in the temple that I have little practical experience " +
                        "dealing with people in the outside world.");
            }
        };
    }

    private void setIdeal(){
        this.idealTraits = new HashMap<Integer,String>(){
            {
                idealTraits.put(1, "Tradition. The ancient traditions of worship and sacrifice must be preserved and "+
                " upheld. (Lawful)");
                idealTraits.put(2, "Charity. I always try to help those in need, no matter what the personal cost. (Good)");
                idealTraits.put(3, "Change. We must help bring about the changes the gods are constantly working in the "+
                "world. (Chaotic)");
                idealTraits.put(4, "Power. I hope to one day rise to the top of my faith's religious hierarchy. (Lawful)");
                idealTraits.put(5, "Faith. I trust that my deity will guid my actions. I have faith that if I work hard, "
                        + ", things will go well. (Lawful)");
                idealTraits.put(6, "Aspiration. I seek to prove myself worthy of my god’s " +
                        "favor by matching my actions against his or her teachings. (Any)");
            }
        };
    }

    private void setBond(){
        this.bondTraits = new HashMap<Integer, String>(){
            {
                bondTraits.put(1, "I would die to recover an ancient relic of my faith that " +
                        "was lost long ago.");
                bondTraits.put(2, "I will someday get revenge on the corrupt temple " +
                        "hierarchy who branded me a heretic");
                bondTraits.put(3, " I owe my life to the priest who took me in when my " +
                        "parents died");
                bondTraits.put(4, "Everything I do is for the common people.");
                bondTraits.put(5, "I will do anything to protect the temple where I served");
                bondTraits.put(6, " seek to preserve a sacred text that my enemies consider heretical and seek to destroy.");
            }
        };
    }

    private void setFlaw(){
        this.flawTraits = new HashMap<Integer, String>(){{

            flawTraits.put(1, "I judge others harshly, and myself even more severely." );
            flawTraits.put(2, "I put too much trust in those who wield power within my temple’s hierarchy.");
            flawTraits.put(3, "My piety sometimes leads me to blindly trust those " +
                    "that profess faith in my god.");
            flawTraits.put(4, "I am inflexible in my thinking.");
            flawTraits.put(5, "I am suspicious of strangers and expect the worst of them.");
            flawTraits.put(6, "Once I pick a goal, I become obsessed with it to the " +
                    "detriment of everything else in my life.");
        }};
    }

}
