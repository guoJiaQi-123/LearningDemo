package com.tyut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/8/20
 * @apiNote 订单控制层
 */
@RequestMapping("/api/order")
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getPayment")
    public Object getPayment() {
        Map map = restTemplate.getForObject("http://localhost:8001/api/payment/findPaymentInfoById?id=1", Map.class);
        return map;
    }
}
