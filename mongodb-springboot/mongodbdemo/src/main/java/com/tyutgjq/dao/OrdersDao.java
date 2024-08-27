package com.tyutgjq.dao;

import com.tyutgjq.entity.Orders;

import java.util.List;

public interface OrdersDao {

    /**
     * 根据订单名称查询订单
     * @param name 订单名称
     * @return 订单集合
     */
    List<Orders> findOrdersByName(String name);

}
