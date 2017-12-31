package com.company.Character;

import com.company.Bag;
import com.company.CharacterPanel.Armor;
import com.company.CharacterPanel.Health;
import com.company.CharacterPanel.Stats;
import com.company.ClassType.*;
import com.company.Items.Equipment.Armor.IArmor;
import com.company.Items.Equipment.*;
import com.company.Items.Equipment.Weapon.IWeapon;
import com.company.RaceType.Race;
import com.company.RaceType.Stats.AttributeEnum.AttributeModify;
import com.company.RaceType.Stats.AttributeEnum.Attribute;
import com.company.Util.EnumContainer.GearSlot;

public class PlayerCharacter {

    private Race race;
    private ClassRole cRole;
    private Bag inventoryBag;
    private EquipmentSystem gear_Equipment;
    private Armor armor;
    private Stats walking_Speed;

    private Health health;
    private String name;


    public PlayerCharacter(String name, Race race, ClassRole cRole, Bag inventoryBag){
        this.name = name;
        this.race = race;
        this.cRole = cRole;
        this.gear_Equipment = new EquipmentSystem();
        this.inventoryBag = inventoryBag;
        this.armor = new Armor();
        this.walking_Speed = new Stats(30);
        set_Health();
        updatePlayer();
    }



    //Composition of other classes that are being built in this class.
    public Race get_Race() {
        return race;
    }
    public ClassRole get_CRole() {
        return cRole;
    }
    public Bag get_InventoryBag(){
        return inventoryBag;
    }
    public EquipmentSystem get_GearEquipment() {
        return gear_Equipment;
    }
    public Armor get_Armor(){ return armor;}
    public Stats get_Movement(){
        return walking_Speed;
    }
    public Health get_Health(){
        return health;
    }

    /**
     * Work on this when creating more classes.
     * THIS IS ONLY INTENDED FOR INSTANTIATING THE CHARACTER!
     */
    private void set_Health(){
        if (cRole instanceof Barbarian){
            this.health = new Health(12 + race.getAttributeStatsValue(Attribute.Constitution));
        }
        else if (cRole instanceof Wizard){
            this.health = new Health(8 + race.getAttributeStatsValue(Attribute.Constitution));
        }
    }

    public int getMax_BagWeight(){
        return race.getAttributeStatsValue(Attribute.Strength) * 15;
    }


    public void updatePlayer(){
        inventoryBag.setMaxBagWeight(getMax_BagWeight() * 15);
        updateArmor();
        if(cRole instanceof Barbarian){
            ((Barbarian) cRole).unArmored_Defense(this);
        }
    }

    private void updateArmor(){
        armor.update(this);
    }
    public int getArmorValue(GearSlot gearSlot){
        return get_GearEquipment().getArmor(gearSlot).getArmor(this.race.getModifyStatsValue(AttributeModify.Dex_Modifier));
    }

    public void equip(IWeapon equipment, GearSlot slot){
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
        else if(equipment instanceof IArmor){
            gear_Equipment.equip((IArmor)equipment, this);
        }
        updatePlayer();
    }

    public String getName(){
        return this.name;
    }
}
