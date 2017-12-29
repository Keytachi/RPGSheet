package com.company.Spell;

import com.company.Util.dice;

import java.util.ArrayList;
import java.util.List;

public abstract class ASpell {

    protected String name;
    protected int level_req;
    protected int damage;

    protected List<Effect> effectsList;


    public ASpell(String name, int level_req, int damage){
        this.name = name;
        this.level_req = level_req;
        this.damage = damage;

        this.effectsList = new ArrayList<>();
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

    public int attack(){
        return dice.roll(damage);
    }
}
