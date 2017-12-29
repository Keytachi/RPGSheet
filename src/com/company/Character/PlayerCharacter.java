package com.company.Character;

import com.company.Bag;
import com.company.ClassType.*;
import com.company.Items.Equipment.Armor.Armor;
import com.company.Items.Equipment.*;
import com.company.Items.Equipment.Weapon.IWeapon;
import com.company.RaceType.Race;
import com.company.RaceType.Stats.AttributeEnum.Attribute;
import com.company.Util.EnumContainer;

public class PlayerCharacter {

    private Race race;
    private ClassRole role;
    private Bag inventoryBag;
    private EquipmentSystem gear_Equipment;
    private Health health;
    private CharacterArmor armor;

    private String name;


    public PlayerCharacter(String name, Race race, ClassRole role, Bag inventoryBag){
        this.name = name;
        this.race = race;
        this.role = role;
        this.gear_Equipment = new EquipmentSystem();
        this.inventoryBag = inventoryBag;
        this.armor = new CharacterArmor();
        setHealth();
        updatePlayer();
    }



    //Composition of other classes that are being built in this class.
    public Race get_Race() {
        return race;
    }
    public ClassRole get_Role() {
        return role;
    }
    public Bag get_InventoryBag(){
        return inventoryBag;
    }
    public EquipmentSystem getGear_Equipment() {
        return gear_Equipment;
    }
    public Health get_Health(){
        return this.health;
    }
    public CharacterArmor get_Armor(){
        return this.armor;
    }

    /**
     * Work on this when creating more classes.
     * THIS IS ONLY INTENDED FOR INSTANTIATING THE CHARACTER!
     */
    private void setHealth(){
        if (role instanceof Barbarian){
            this.health = new Health(12 + race.getBaseStats(Attribute.Constitution).getFinalStats());
        }
        else if (role instanceof Wizard){
            this.health = new Health(8 + race.getBaseStats(Attribute.Constitution).getFinalStats());
        }
    }

    public int getMax_BagWeight(){
        return race.getBaseStats(Attribute.Strength).getFinalStats() * 15;
    }


    public void updatePlayer(){
        inventoryBag.setMaxBagWeight(getMax_BagWeight() * 15);
        updateArmor();
        /**if(role instanceof Barbarian){
            ((Barbarian)role).unArmored_Defense(this);
        }*/
    }

    private void updateArmor(){
        armor.updateArmor(this);
    }

    public void equip(IWeapon equipment, EnumContainer.GearSlot slot){
            try {
                gear_Equipment.equip( equipment, slot, this);
            }catch(NotCorrectSlotException e){
                System.out.println(e.getEquipment() + " can not be equipped on " + e.getSlot());
            }
    }
    public void equip(IEquipment equipment){
        if(equipment instanceof IWeapon){
            gear_Equipment.equip((IWeapon)equipment, this);
        }
        else if(equipment instanceof Armor){
            gear_Equipment.equip((Armor)equipment, this);
        }
        updatePlayer();
    }

    public String getName(){
        return this.name;
    }
}
