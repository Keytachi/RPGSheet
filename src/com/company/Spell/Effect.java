package com.company.Spell;

import com.company.Character.PlayerCharacter;
import com.company.RaceType.Stats.AttributeEnum;

public class Effect implements IBuff{

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

    public enum Target_Type{
        Armor,
        Attribute,
        Walk,
        Skill,
    }

    protected Target_Type target_type;
    private String name;
    private int id;
    private int statsRate;
    private Effects_Type effect_type;
    private int duration;
    AttributeEnum.Attribute target_Attribute;

    public Effect(int id, String name,Effects_Type effect_type, int statsEffect,int duration,Target_Type target_type){
        this.id = id;
        this.name = name;
        this.effect_type = effect_type;
        this.statsRate = statsEffect;
        this.duration = duration;
        this.target_type = target_type;
    }

    public AttributeEnum.Attribute getTarget_Attribute(){
        return target_Attribute;
    }

    @Override
    public int getStatsRate(){
        return statsRate;
    }

    @Override
    public Target_Type getTarget_type(){
        return target_type;
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
    public void effect(PlayerCharacter target) {
        switch(target_type){
            case Armor:
                target.get_Armor().addBonusArmor(this);
                break;
            case Walk:
                target.get_Race().setWalking_Speed(target.get_Race().getWalking_Speed() - statsRate);
                break;
            case Attribute:
                target.get_Race().getAttributeMap().get(this.getTarget_Attribute()).addAdditiveBonus(this);
                break;

        }
    }

    @Override
    public String toString(){
        return name;
    }
}
