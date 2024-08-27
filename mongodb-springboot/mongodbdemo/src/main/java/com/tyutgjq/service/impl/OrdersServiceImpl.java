package com.tyutgjq.service.impl;

import com.tyutgjq.dao.OrdersDao;
import com.tyutgjq.entity.Orders;
import com.tyutgjq.repository.OrdersRepository;
import com.tyutgjq.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private OrdersRepository ordersRepository;


    @Override
    public List<Orders> findOrders(String name) {

        return ordersDao.findOrdersByName(name);
    }

    @Override
    public List<Orders> findOrders_2(String name) {
        return ordersRepository.findOrdersByName(name);
    }
}
