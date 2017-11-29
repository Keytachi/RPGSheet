package com.company.RaceType;
import com.company.Entity;
import com.company.Util.dice;

public abstract class Race extends Entity {

    private String name;

    protected int str_Modifier;
    protected int dex_Modifier;
    protected int cons_Modifier;
    protected int int_Modifier;
    protected int wis_Modifier;
    protected int char_Modifier;

    protected int walking_Speed;



    public Race(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, String name) {
        super(strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.name = name;
    }

    public Race(String name){
        super(dice.rollStats(6,4),dice.rollStats(6,4),
                dice.rollStats(6,4),dice.rollStats(6,4),
                dice.rollStats(6,4), dice.rollStats(6,4));
        this.name = name;
        this.walking_Speed = 30;
    }

    public String getName() {
        return name;
    }

    private int setModifier(int modifier){
        return ((modifier-10)/2);
    }

    public abstract void specialty();

    public void setModify(){
        this.str_Modifier = setModifier(this.strength);
        this.dex_Modifier = setModifier(this.dexterity);
        this.cons_Modifier = setModifier(this.constitution);
        this.int_Modifier = setModifier(this.intelligence);
        this.wis_Modifier = setModifier(this.wis_Modifier);
        this.char_Modifier = setModifier(this.char_Modifier);
    }

    public int getStr_Modifier() {
        return str_Modifier;
    }
    public void setStr_Modifier(int str_Modifier) {
        this.str_Modifier = str_Modifier;
    }

    public int getDex_Modifier() {
        return dex_Modifier;
    }
    public void setDex_Modifier(int dex_Modifier) {
        this.dex_Modifier = dex_Modifier;
    }

    public int getCons_Modifier() {
        return cons_Modifier;
    }
    public void setCons_Modifier(int cons_Modifier) {
        this.cons_Modifier = cons_Modifier;
    }

    public int getInt_Modifier() {
        return int_Modifier;
    }
    public void setInt_Modifier(int int_Modifier) {
        this.int_Modifier = int_Modifier;
    }

    public int getWis_Modifier() {
        return wis_Modifier;
    }
    public void setWis_Modifier(int wis_Modifier) {
        this.wis_Modifier = wis_Modifier;
    }

    public int getChar_Modifier() {
        return char_Modifier;
    }
    public void setChar_Modifier(int char_Modifier) {
        this.char_Modifier = char_Modifier;
    }

    public int get_WalkingSpeed(){
        return this.walking_Speed;
    }
    public void set_WalkingSpeed(int walking_Speed){
        this.walking_Speed = walking_Speed;
    }
}
