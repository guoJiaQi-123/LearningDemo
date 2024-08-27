package com.tyut.controller;

import com.tyut.feign.PaymentFeignService;
import com.tyut.domain.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/8/21
 * @apiNote 订单控制层
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/getPayment")
    public R getPayment(@RequestParam("id") Long id) {
        return paymentFeignService.findPaymentInfoById(id);
    }

    @GetMapping("/info")
    public R info() {
        return paymentFeignService.info();
    }

}
