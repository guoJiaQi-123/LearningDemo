package com.tyutgjq.service;


import com.tyutgjq.entity.Orders;

import java.util.List;

public interface OrdersService {

    /**
     * 根据订单名称查询订单
     * @param name 订单名称
     * @return 订单集合
     */
    List<Orders> findOrders(String name);

    /**
     * 根据订单名称查询订单 - 继承 MongoRepository接口的方式
     * @param name 订单名称
     * @return 订单集合
     */
    List<Orders> findOrders_2(String name);

}
