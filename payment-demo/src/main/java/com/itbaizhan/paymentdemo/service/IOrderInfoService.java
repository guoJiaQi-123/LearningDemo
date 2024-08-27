package com.itbaizhan.paymentdemo.service;

import com.itbaizhan.paymentdemo.controller.dto.OrderInfoDTO;
import com.itbaizhan.paymentdemo.entity.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.paymentdemo.enums.OrderStatus;

import java.util.List;


public interface IOrderInfoService extends IService<OrderInfo> {
    /**
     * 创建订单
     * @param orderInfoDTO 订单传输对象
     * @return 订单对象
     */
    OrderInfo createOrder(OrderInfoDTO orderInfoDTO);

    /**
     * 根据订单编号查询订单
     * @param orderNo 订单编号
     * @return 查询到的订单
     */
    OrderInfo findByOrderNo(String orderNo);

    /**
     * 更新订单的 CodeUrl 字段
     * @param id 订单ID
     * @param codeUrl 二维码链接
     */
    void saveCodeUrl(Long id,String codeUrl);


    /**
     * 根据订单ID更新订单状态
     * @param id 订单ID
     * @param orderStatus 订单状态
     */
    void updateOrderStatus(Long id, OrderStatus orderStatus);

    /**
     * 根据订单编号更新订单状态
     * @param orderNo 订单编号
     * @param orderStatus 订单状态
     */
    void updateOrderStatus(String orderNo, OrderStatus orderStatus);


    /**
     * 查询超时订单
     * @param minutes 分钟
     * @return 超时的订单集合
     */
    List<OrderInfo> findTimeOutOrders(int minutes);
}
