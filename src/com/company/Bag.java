package com.company;

import com.company.Items.Equipment.Item;

import java.util.ArrayList;

public class Bag {

    private String name;
    private int maxBagSpace;
    private int maxBagWeight;


    private ArrayList<Item> inventoryBag;

    public Bag(String name,int space) {
        this.name = name;
        this.maxBagSpace = space;
        this.inventoryBag = new ArrayList<Item>();
    }

    public String getName() {
        return name;
    }

    public int getMaxBagSpace() {
        return maxBagSpace;
    }

    public ArrayList<Item> getInventoryBag() {
        return inventoryBag;
    }

    public void displayItemsinBag(){
        for(Item items: inventoryBag){
            System.out.println(items);
        }
    }

    private void setMaxBagWeight(int maxBagWeight){
        this.maxBagWeight = maxBagWeight;
    }

    public void removeItem(Item item){
        inventoryBag.remove(item);
    }


    public void storeItem(PlayerCharacter person, Item item){
        setMaxBagWeight(person.getMax_BagWeight() * 15);
        if(item.getWeight() + getWeight_ofBag() > maxBagWeight || inventoryBag.size() > maxBagSpace){
            System.out.printf("%s could not store %s in their bag\n", person.getRace().getName(), item.getName());
        }else{
            inventoryBag.add(item);
        }
    }

    public int getWeight_ofBag(){
        int total_Weight = 0;

        for(Item items : inventoryBag){
            total_Weight+= items.getWeight();
        }
        return total_Weight;
    }
}
