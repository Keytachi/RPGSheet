package com.company.Spell;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ble on 12/30/2017.
 */

public class SpellBook {

    public enum TypeofBook{
        Cantrip,
        Level1,
        Level2,
        Level3,
        Level4,
        Level5
    }

    private HashMap<TypeofBook,ArrayList<ASpell>> spellBook;

    public SpellBook(){
        this.spellBook = new HashMap<TypeofBook, ArrayList<ASpell>>(){{
            put(TypeofBook.Cantrip,new ArrayList<>());
            put(TypeofBook.Level1, new ArrayList<>());
            put(TypeofBook.Level2, new ArrayList<>());
            put(TypeofBook.Level3, new ArrayList<>());
            put(TypeofBook.Level4, new ArrayList<>());
            put(TypeofBook.Level5, new ArrayList<>());
        }};
    }

    public void addSpelltoBook(TypeofBook bookSection, ASpell spell){
        spellBook.get(bookSection).add(spell);
    }
}
