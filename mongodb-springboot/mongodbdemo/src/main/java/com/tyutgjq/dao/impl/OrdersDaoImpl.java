package com.tyutgjq.dao.impl;

import com.tyutgjq.dao.OrdersDao;
import com.tyutgjq.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersDaoImpl implements OrdersDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Orders> findOrdersByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Orders.class);
    }

}
