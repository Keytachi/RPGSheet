package com.company.Items.Equipment.Weapon;

import com.company.Items.Equipment.Item;
import com.company.Character.PlayerCharacter;
import com.company.Util.EnumContainer;
import com.company.Util.dice;

import com.company.RaceType.Stats.AttributeEnum.AttributeModify;

import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Hand_Req;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Attack_Type;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Weapon_Type;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Properties;
import com.company.Items.Equipment.Weapon.Weapon_EnumContainer.Weapon_Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ble on 12/22/2017.
 */

public abstract class AWeapon extends Item implements IWeapon {

    protected int damage;
    protected boolean equipped;
    protected List<Properties> specialty;
    protected Attack_Type attackType;
    protected Weapon_Category weaponCategories;
    protected Weapon_Type weaponType;
    protected Hand_Req handReq;


    public AWeapon(int weight, int cost, int damage, String name) {
        super(name,weight,cost, false, true);
        this.damage = damage;
        this.equipped = false;
        this.specialty = new ArrayList<>();
    }

    @Override
    public int getCost(){
        return cost;
    }

    public int getDamage() {
        return damage;
    }

    public int attack(PlayerCharacter host){

        for(Properties special : specialty)
        switch(special){
            case FINESSES:
                return dice.roll(damage) + host.get_Race().getModifyStatsValue(AttributeModify.Dex_Modifier);
            case LIGHT:
                for(EnumContainer.GearSlot hand : EnumContainer.weapon_Slot) {
                    if ((host.get_GearEquipment().getWeaponEquipment().get(hand).getProperties().equals(Properties.LIGHT))){
                        host.get_GearEquipment().getWeaponEquipment().get(hand).attack();
                    }
                }
                break;
            case VERSATILE:
                return dice.roll(8);

        }
        return attack();
    }

    public int attack(){
        return dice.roll(damage);
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
    public Weapon_Category getCategories() {
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
    public List<Properties> getProperties() {
        return specialty;
    }
}
