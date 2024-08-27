package com.tyutgjq.controller;

import com.tyutgjq.entity.Orders;
import com.tyutgjq.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;


    /**
     * 根据订单名查询订单
     * @param name 订单名
     * @return 订单
     */
    @RequestMapping("/Orders")
    private List<Orders> findOrders(String name) {
        return ordersService.findOrders(name);
    }

    /**
     * 根据订单名查询订单 - dao层通过实现 MongoRepository接口的方式实现
     * @param name 订单名
     * @return 订单
     */
    @RequestMapping("/Orders2")
    private List<Orders> findOrders2(String name) {
        return ordersService.findOrders_2(name);
    }
}
