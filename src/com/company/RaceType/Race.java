package com.company.RaceType;

import com.company.ClassType.Barbarian;
import com.company.ClassType.ClassRole;
import com.company.ClassType.Mage;
import com.company.Entity;
import com.company.Util.dice;

public abstract class Race extends Entity {

    private String name;
    private ClassRole role;

    private int current_Health;
    private int maximum_Health;

    protected int str_Modifier;
    protected int dex_Modifier;
    protected int cons_Modifier;
    protected int int_Modifier;
    protected int wis_Modifier;
    protected int char_Modifier;

    protected int walking_Speed;

    //TODO: Implement limitation of what race can use of certain items.
    protected enum EquipableWeapon{
        LONGSWORD,
        SHORTSWORD,

        LONGBOW,
        SHORTBOW,
        CROSSBOW,

        JAVELIN,
        TRIDENT,
        LANCE,

        BATTLEAXE,
        HANDAXE,
        THROWING_HAMMER,
        WARHAMMER,


    }

    //TODO: Implement inventory items with gear system.
    public Race(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, String name,
                ClassRole role) {
        super(strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.name = name;
        this.role = role;
    }

    public Race(String name, ClassRole role){
        super(dice.rollStats(6,4),dice.rollStats(6,4),
                dice.rollStats(6,4),dice.rollStats(6,4),
                dice.rollStats(6,4), dice.rollStats(6,4));
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getCurrent_Health() {
        return current_Health;
    }

    public void setCurrent_Health(int current_Health) {
        this.current_Health = current_Health;
        if(this.current_Health > this.maximum_Health){
            this.current_Health = this.maximum_Health;
        }
    }

    public int getMaximum_Health() {
        return maximum_Health;
    }

    public void setMaximum_Health(int maximum_Health) {
        this.maximum_Health = maximum_Health;
    }

    public ClassRole getRole() {
        return role;
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

    public void setHealth(){
        if (this.role instanceof Barbarian){
            this.maximum_Health = 12 + this.cons_Modifier;
            this.current_Health = this.maximum_Health;
        }
        else if (this.role instanceof Mage){
            this.maximum_Health = 8 + this.cons_Modifier;
            this.current_Health = this.maximum_Health;
        }
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
