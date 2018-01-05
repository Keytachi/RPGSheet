package com.company;


import com.company.Character.PlayerCharacter;
import com.company.ClassType.Barbarian;
import com.company.Items.Equipment.Weapon.Simple.SimpleMeleeWeapon.Unarm;
import com.company.RaceType.Human;
import com.company.RaceType.Stats.AttributeEnum;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.server.DB;
import com.server.DocumentWriter;
import org.bson.Document;

public class Main {

    public static void main(String[] args) {
        PlayerCharacter brandon = new PlayerCharacter("Brandon",new Human(),
                new Barbarian(),new Bag("Bag",32));

        /**Document statsHolder = DocumentWriter.writeAttribute(brandon);
        Document modifyHolder = DocumentWriter.writeModify(brandon);

        DB mongo = new DB("myTestDB", "Player");
        Document document = new Document("name", brandon.getName());
        document.put("name", brandon.getName());
        document.put("race", new Document("name", brandon.get_Race().toString())
        .append("stats", statsHolder)
        .append("modify", modifyHolder));


        System.out.println(mongo.getDatabase().getName());
        mongo.getCollection().insertOne(document);
        */

        Unarm testWeapon = new Unarm();

        Document weapDoc = new Document("Name", testWeapon.toString());
        weapDoc.append("Damage Die", testWeapon.getDamage());
        weapDoc.append("Cost", testWeapon.getCost());
        weapDoc.append("Weight", testWeapon.getWeight());
        weapDoc.append("Weapon Type", testWeapon.getWeaponType().toString());
        weapDoc.append("Hand Requirement", testWeapon.getHandReq().toString());
        weapDoc.append("Attack Type", testWeapon.getAttackType().toString());
        weapDoc.append("Weapon Category", testWeapon.getCategories().toString());

        DB mongo = new DB("myTestDB","Weapons");
        mongo.getCollection().insertOne(weapDoc);


    }
}
