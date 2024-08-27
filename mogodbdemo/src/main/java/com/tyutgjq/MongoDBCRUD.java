package com.tyutgjq;

import com.mongodb.client.*;
import org.bson.Document;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MongoDBCRUD {
    public static void main(String[] args) throws IOException {
        MongoClient mongoClient = getMongoClient("mongod.properties");
        // 获取要操作的数据库
        MongoDatabase database = mongoClient.getDatabase("test");
        // 获取要操作的集合
        MongoCollection<Document> collection = database.getCollection("javaCreat");
        // 获取文档对象
//        Document document1 = Document.parse("{name:'lisi',city:'bj',birth_day:new ISODate('2001-08-01'),expectSalary:18000}");
//        Document document2 = Document.parse("{name:'zhangsan',city:'bj',birth_day:new ISODate('2001-08-01'),expectSalary:12000}");
//        Document document3 = Document.parse("{name:'wangwu',city:'bj',birth_day:new ISODate('2001-08-01'),expectSalary:14000}");
//        collection.insertOne(document1);
//        collection.insertOne(document2);
//        collection.insertOne(document3);
//        Document expectSalary = new Document();
//        expectSalary.append("expectSalary",1);
//        FindIterable<Document> documents = collection.find().sort(expectSalary);
//

        FindIterable<Document> documents = collection.find(new Document("expectSalary", new Document("$eq", 18000)));
        for (Document document : documents) {
            System.out.println(document.toJson());
        }
        mongoClient.close();

    }


    private static MongoClient getMongoClient(String uri) throws IOException {
        InputStream resourceAsStream = MongoDBCRUD.class.getClassLoader().getResourceAsStream(uri);
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String mongoDB = properties.getProperty("mongoDB");
        return MongoClients.create(mongoDB);
    }
}
