package com.tyutgjq;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class MongoDBConnection2 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        InputStream resourceAsStream = MongoDBConnection2.class.getClassLoader().getResourceAsStream("mongod.properties");
        try {
            properties.load(resourceAsStream);
            String db = properties.getProperty("mongoDB");
            MongoClient mongoClient = MongoClients.create(db);
            MongoDatabase testDatabase = mongoClient.getDatabase("test");
            testDatabase.createCollection("javaCreat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
