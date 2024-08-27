package com.tyutgjq.repository;

import com.tyutgjq.entity.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrdersRepository extends MongoRepository<Orders,String> {
    List<Orders> findOrdersByName(String name);
}
