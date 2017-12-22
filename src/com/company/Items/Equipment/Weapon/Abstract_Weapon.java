package com.company.Items.Equipment.Weapon;

import com.company.Items.Equipment.Item;
import com.company.Util.dice;

/**
 * Created by ble on 12/22/2017.
 */

public abstract class Abstract_Weapon extends Item implements Weapon {

    protected int damage;
    protected int cost;
    protected int weight;
    protected boolean equipped;
    protected Attack_Type attackType;
    protected Weapon_Categories weaponCategories;
    protected Weapon_Type weaponType;
    protected Hand_Req handReq;


    public Abstract_Weapon(int weight, int cost, int damage, String name) {
        super(name);
        this.weight = weight;
        this.cost = cost;
        this.damage = damage;
        this.equipped = false;
    }

    @Override
    public int getCost(){
        return cost;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public int attack(){
        return dice.roll(getDamage());
    }

    @Override
    public Hand_Req getHandReq() {
        return handReq;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public Weapon_Categories getCategories() {
        return weaponCategories;
    }

    @Override
    public Attack_Type getAttackType() {
        return attackType;
    }

    @Override
    public Weapon_Type getWeaponType() {
        return weaponType;
    }

    @Override
    public boolean isEquipped(){
        return this.equipped;
    }

    @Override
    public void setEquipped(boolean equipped){
        this.equipped = equipped;
    }
}
