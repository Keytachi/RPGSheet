package com.company.Spell;

import com.company.Character.PlayerCharacter;

public abstract class Effect implements IBuff{

    public enum Effects_Type{
        Heal_OT("Heal Over Time"),
        Damage_OT("Damage Over Time"),
        Buff("Buff"),
        Debuff("Debuff");

        private String name;
        Effects_Type(String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return name;
        }
    }

    private Effects_Type effect_type;
    private int duration;

    public Effect(Effects_Type effect_type, int duration){
        this.effect_type = effect_type;
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public Effects_Type getEffect_type() {
        return effect_type;
    }

    @Override
    public void effect(PlayerCharacter host) {

    }
}
