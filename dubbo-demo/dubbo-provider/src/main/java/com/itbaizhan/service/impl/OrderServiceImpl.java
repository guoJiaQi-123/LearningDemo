package com.itbaizhan.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itbaizhan.pojo.CommonResult;
import com.itbaizhan.pojo.Orders;
import com.itbaizhan.service.IOrderService;
import org.springframework.boot.availability.AvailabilityChangeEvent;


/**
 * 订单功能业务层
 */
@Service
@SuppressWarnings("all")
public class OrderServiceImpl implements IOrderService {


    /**
     * 创建订单
     */
    @Override
    public CommonResult  createOrders(Orders order) {
        CommonResult commonResult = new CommonResult();
        // 返回结果编码
        commonResult.setCode(200);
        // 返回结果描述信息
        commonResult.setMessage("创建成功");
        return commonResult;
    }

    /**
     * 根据用户id查询订单详情
     */
    @Override
    public CommonResult<Orders> findByUserId(Long userId) {
        // TODO 模拟数据库操作
        CommonResult commonResult = new CommonResult();
        // 返回结果编码
        commonResult.setCode(200);
        // 返回结果描述信息
        commonResult.setMessage("查询成功");
        // 返回结果集
        Orders orders = new Orders();
        orders.setId(1L);
        orders.setUserId(1L);
        orders.setPrice(121.1);
        orders.setMobile("17777777");
        orders.setAddress("上海市海淀区中关村");
        orders.setPay_method(1);
        commonResult.setData(orders);
        return commonResult;
    }
}