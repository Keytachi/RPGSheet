package com.company.Items.Equipment;

import com.company.Items.Equipment.Armor.Armor;
import com.company.Items.Equipment.Armor.Naked;
import com.company.Items.Equipment.Weapon.Simple.SimpleMeleeWeapon.Club;
import com.company.Items.Equipment.Weapon.Weapon;
import com.company.Util.EnumContainer;
import com.company.Util.EnumContainer.GearSlot;

import java.util.HashMap;
import java.util.Map;

public class EquipmentSystem {


    private Map<EnumContainer.GearSlot,Abstract_Equipment> armorEquipment;
    private Map<EnumContainer.GearSlot,Weapon> weaponEquipment;

    public EquipmentSystem(){
        this.armorEquipment = new HashMap<EnumContainer.GearSlot,Abstract_Equipment>(){
            {
                put(GearSlot.ARMOR, new Naked());
            }};
        this.weaponEquipment = new HashMap<EnumContainer.GearSlot,Weapon>(){
            {
                put(GearSlot.LHAND, new Club());
                put(GearSlot.RHAND, new Club());
            }
        };
    }

    public Map<GearSlot,Abstract_Equipment> getArmorEquipment(){
        return this.armorEquipment;
    }
    public Map<GearSlot,Weapon> getWeaponEquipment() {return this.weaponEquipment;}

    public Abstract_Equipment getArmor(GearSlot gearSlot){
        return this.armorEquipment.get(gearSlot);
    }

    public Weapon getWeapon(GearSlot gearSlot){return this.weaponEquipment.get(gearSlot);}

    public void equip(Weapon weapon){
         try{equip(weapon,weaponEquipment);}
         catch(BagIsFullException e){}
    }

    public void equip(Armor armor){


        try{equip(armor,armorEquipment);}
        catch(BagIsFullException e){

        }
    }

    private void equip(Abstract_Equipment equipment, Map equipmentSlots) throws BagIsFullException{
        for(Object gear : equipmentSlots.values()){
            int weight = equipment.getWeight();
            if (weight > 10)
                throw new BagIsFullException();

        }
    }
}

class BagIsFullException extends Exception{}
