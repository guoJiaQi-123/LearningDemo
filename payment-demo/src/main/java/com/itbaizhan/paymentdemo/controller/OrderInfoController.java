package com.itbaizhan.paymentdemo.controller;

import com.itbaizhan.paymentdemo.controller.dto.OrderInfoDTO;
import com.itbaizhan.paymentdemo.entity.OrderInfo;
import com.itbaizhan.paymentdemo.ov.BaseResult;
import com.itbaizhan.paymentdemo.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote 订单实体类
 */
@Controller
@RequestMapping("/api/order")
public class OrderInfoController {

    private final IOrderInfoService orderInfoService; // 订单接口

    @Autowired
    public OrderInfoController(IOrderInfoService orderInfoService) {
        this.orderInfoService = orderInfoService;
    }

    /**
     * 根据订单标题和订单金额创建订单
     * @param orderInfoDTO 封装订单标题和订单金额属性的订单 DTO 数据传输对象
     * @return 创建的订单
     */
    @PostMapping("/createOrder")
    public @ResponseBody BaseResult<OrderInfo> createOrder(OrderInfoDTO orderInfoDTO) {
        OrderInfo order = orderInfoService.createOrder(orderInfoDTO);
        return BaseResult.ok(order);
    }
}
