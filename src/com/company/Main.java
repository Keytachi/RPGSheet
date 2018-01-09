package com.company;


import com.company.Character.PlayerCharacter;
import com.company.CharacterPanel.PlayerCharacterIO;
import com.company.ClassType.Barbarian;
import com.company.Items.Equipment.Armor.Heavy_Armor.ChainMail;
import com.company.Items.Equipment.Armor.Shield;
import com.company.Items.Equipment.IEquipment;
import com.company.Items.Equipment.Weapon.Simple.SimpleMeleeWeapon.Club;
import com.company.Items.Equipment.Weapon.Simple.SimpleTwoHand.GreatClub;
import com.company.RaceType.Human;
import com.company.Spell.ASpell;
import com.company.Spell.Buff;
import com.company.Spell.Effect;
import com.company.Spell.SpellBook;

import javax.swing.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        PlayerCharacter brandon = new PlayerCharacter("Brandon",new Human(),
                new Barbarian(),new Bag("Bag",32));


        PlayerCharacterIO.displayHealth(brandon);
        brandon.equip(new ChainMail());
        brandon.equip(new Shield());

        System.out.println(brandon.get_Armor().getFinalValue());

        ASpell fireball = new ASpell(1,"Fireball",1,-6, SpellBook.TypeofBook.Level1);
        fireball.addEffect(new Buff(1001,"Burn", Effect.Effects_Type.Damage_OT,-2));
        fireball.attack(brandon);

        PlayerCharacterIO.displayHealth(brandon);
        PlayerCharacterIO.displayEXP(brandon);

        brandon.get_Level().set_CurrentEXP(500);

        brandon.get_Level().set_CurrentEXP(400);
        PlayerCharacterIO.displayEXP(brandon);


        Game game = new Game();
        SocketClient client = new SocketClient(game, "localhost", 8001);
        client.connectToServer();
        client.sendMessage("wut");

        JFrame frame = new JFrame("RPGSheet");
        Window gameWindow = new Window();
        frame.add(gameWindow);
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.startDrawLoop();

    }
    public void handleMessageFromServer(String msg){

    }
}
