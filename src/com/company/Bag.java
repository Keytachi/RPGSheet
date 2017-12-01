package com.company;

import java.util.ArrayList;

public class Bag {

    private String name;
    private int space;

    private ArrayList<Item> inventoryBag;

    public Bag(String name,int space) {
        this.name = name;
        this.space = space;
        this.inventoryBag = new ArrayList<Item>();
    }

    public String getName() {
        return name;
    }

    public int getSpace() {
        return space;
    }

    public ArrayList<Item> getInventoryBag() {
        return inventoryBag;
    }

    public void displayIteminBag(){
        for(Item items: inventoryBag){
            System.out.println(items);
        }
    }

    public void removeItem(Item item){
        inventoryBag.remove(item);
    }
    public void storeItem(PlayerCharacter person, Item item){
        if(item.getWeight() + getWeight_ofBag() > person.getMax_BagWeight() || inventoryBag.size() > space){
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
