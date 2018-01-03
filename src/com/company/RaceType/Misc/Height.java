package com.company.RaceType.Misc;

import com.company.Util.dice;

/**
 * Created by ble on 1/3/2018.
 */

public class Height {

    private int base_Height;
    private int height_Modifier;
    private int base_Weight;
    private int weight_Modifier;

    public Height(int base_Height, int base_Weight,int height_Modifier, int weight_Modifier){
        this.base_Height = base_Height;
        this.base_Weight = base_Weight;
        this.height_Modifier = height_Modifier;
        this.weight_Modifier = weight_Modifier;
        set_BaseHeight();
        set_BaseWeight();
    }

    public int get_BaseHeight() {
        return base_Height;
    }

    public int get_BaseWeight() {
        return base_Weight;
    }

    public void set_BaseHeight(){
        this.base_Height += 2*(dice.roll(height_Modifier));
    }

    public void set_BaseWeight(){
        this.base_Weight += (2*(dice.roll(height_Modifier))) * (2*(dice.roll(weight_Modifier)));
    }
}
