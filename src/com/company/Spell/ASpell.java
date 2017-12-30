package com.company.Spell;

import com.company.Character.PlayerCharacter;
import com.company.Util.dice;

import java.util.ArrayList;
import java.util.List;

public class ASpell {

    protected int id;
    protected String name;
    protected int level_req;
    protected int damage;

    protected List<Effect> effectsList;
    protected SpellBook.TypeofBook book_Level;


    public ASpell(int id, String name, int level_req, int damage, SpellBook.TypeofBook book_Level) {
        this.id = id;
        this.name = name;
        this.level_req = level_req;
        this.damage = damage;

        this.effectsList = new ArrayList<>();
        this.book_Level = book_Level;
    }

    public int getId() {
        return id;
    }

    public void addEffect(Effect effect){
        this.effectsList.add(effect);
    }

    public String getName() {
        return name;
    }

    public int getLevel_req() {
        return level_req;
    }

    public int getDamage() {
        return damage;
    }

    public int attack(PlayerCharacter target){
        if(!effectsList.isEmpty()) {
            for (Effect type : effectsList) {
                type.effect(target);
            }
        }
        return dice.roll(damage);
    }
}
