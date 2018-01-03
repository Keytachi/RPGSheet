package com.company.Character;

public class LevelSystem {

    private int level;
    private int exp_Req;
    private int current_Exp;

    public LevelSystem(int level, int current_Exp){
        this.level = level;
        this.current_Exp = current_Exp;
        get_EXPRequirement();
    }

    /**
     * This is intended to be use for when starting a level one character.
     * Otherwise use to other function with overload to set the character to a specific level.
     */
    public LevelSystem(){
        this(1,0);
    }


    private void get_EXPRequirement(){
        switch(level){
            case 1:
                this.exp_Req = 300;
                break;
            case 2:
                this.exp_Req = 900;
                break;
            case 3:
                this.exp_Req = 2700;
                break;
            case 4:
                this.exp_Req = 6500;
                break;
            case 5:
                this.exp_Req = 14000;
                break;

        }
    }

    public void set_CurrentEXP(int expValue){
        this.current_Exp += expValue;
        if(current_Exp >= exp_Req){
            levelUp();
        }
    }

    private void set_Level(int levelValue){
        this.level += levelValue;
    }

    private void levelUp(){
        set_Level(1);
        get_EXPRequirement();
    }

    public int get_Level(){
        return level;
    }

    public int get_EXPReq(){
        return exp_Req;
    }

    public int get_CurrentEXP(){
        return current_Exp;
    }
}
