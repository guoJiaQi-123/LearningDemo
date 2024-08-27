package com.itbaizhan.service;


import com.itbaizhan.pojo.CommonResult;
import com.itbaizhan.pojo.Orders;

public interface IOrderService {
    //创建订单
    CommonResult createOrders(Orders orders);


    //根据用户id查询订单详情
    CommonResult findByUserId(Long userid);


}