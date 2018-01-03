package com.company;


import com.company.Character.PlayerCharacter;
import com.company.CharacterPanel.PlayerCharacterIO;
import com.company.ClassType.Barbarian;
import com.company.Items.Equipment.Armor.Heavy_Armor.ChainMail;
import com.company.Items.Equipment.Armor.Shield;
import com.company.RaceType.Human;
import com.company.Spell.Spell;
import com.company.Spell.Buff;
import com.company.Spell.Effect;
import com.company.Spell.SpellBook;

public class Main {

    public static void main(String[] args) {
        PlayerCharacter brandon = new PlayerCharacter("Brandon",new Human(),
                new Barbarian(),new Bag("Bag",32));


        PlayerCharacterIO.displayHealth(brandon);
        brandon.equip(new ChainMail());
        brandon.equip(new Shield());

        System.out.println(brandon.get_Armor().getFinalValue());

        Spell fireball = new Spell(1,"Fireball",1,-6, SpellBook.TypeofBook.Level1);
        fireball.addEffect(new Buff(1001,"Burn", Effect.Effects_Type.Damage_OT,-2));
        fireball.attack(brandon);

        PlayerCharacterIO.displayHealth(brandon);
        PlayerCharacterIO.displayEXP(brandon);

        brandon.get_Level().set_CurrentEXP(500,brandon);
        PlayerCharacterIO.displayHealth(brandon);

        brandon.get_Level().set_CurrentEXP(400,brandon);
        PlayerCharacterIO.displayHealth(brandon);
        PlayerCharacterIO.displayEXP(brandon);

        PlayerCharacterIO.displayHeightWeight(brandon);

    }
}
