package com.server;

import com.mongodb.*;
import com.company.Character.PlayerCharacter;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DB {

    MongoClient client;
    MongoClientURI uri;
    MongoDatabase database;
    MongoCollection collection;

    public DB(String database, String collection){
        //this.uri = new MongoClientURI(uri);
        this.client = new MongoClient("localhost", 27017);
        this.database = client.getDatabase(database);
        setCollection(collection);

    }

    private void setCollection(String collection){
        this.collection = database.getCollection(collection);
    }

    public MongoClient getClient() {
        return client;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection getCollection() {
        return collection;
    }
}
