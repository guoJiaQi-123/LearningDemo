package com.tyutgjq;

import com.mongodb.DBCollection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.ArrayList;

public class MongoDBConnection {
    public static void main(String[] args) {
        String mongodb = System.getProperty("mongodb.uri");

        try {
            MongoClient mongoClient = MongoClients.create(mongodb);
            ArrayList<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> {
                System.out.println(db.toJson());
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
