package com.company.Spell;

import com.company.Character.PlayerCharacter;
import com.company.RaceType.Stats.AttributeEnum;

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

    public Effect(int id, String name,Effects_Type effect_type, int statsRate,int duration,Target_Type target_type){
        this.id = id;
        this.name = name;
        this.effect_type = effect_type;
        this.statsRate = statsRate;
        this.duration = duration;
        this.target_type = target_type;
    }

    public Effect(int id, String name,Effects_Type effect_type, int statsRate,Target_Type target_type) {
        this.target_type = target_type;
        this.name = name;
        this.id = id;
        this.statsRate = statsRate;
        this.effect_type = effect_type;
    }

    public Effect(int id, String name, Effects_Type effect_type, int statsRate){
        this.id = id;
        this.name = name;
        this.effect_type = effect_type;
        this.statsRate = statsRate;
    }

    public AttributeEnum.Attribute getTarget_Attribute(){
        return target_Attribute;
    }

    public String getName(){
        return name;
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
    public void afterEffect(PlayerCharacter target){
        switch(effect_type){
            case Damage_OT:
            case Heal_OT:
                target.get_CurrentHealth().addTempBuff(this);
                break;
            case Buff:
            case Debuff:
                effect(target);
                break;
        }
    }

    @Override
    public void effect(PlayerCharacter target) {
        switch(target_type){
            case Armor:
                target.get_Armor().addTempBuff(this);
                break;
            case Walk:
                target.get_Movement().addTempBuff(this);
                break;
            case Attribute:
                target.get_Race().getAttributeStats().get(this.getTarget_Attribute()).addTempBuff(this);
                break;

        }
    }

    @Override
    public String toString(){
        return name;
    }
}
