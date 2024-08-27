package com.itbaizhan.paymentdemo.task;

import com.itbaizhan.paymentdemo.entity.OrderInfo;
import com.itbaizhan.paymentdemo.service.IOrderInfoService;
import com.itbaizhan.paymentdemo.service.IWxPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/04/19
 * @apiNote 微信支付任务调度
 */
@Component
@Slf4j
public class WxPaymentTask {

    private final IOrderInfoService orderInfoService; // 订单接口

    private final IWxPaymentService wxPaymentService; // 微信支付接口

    public WxPaymentTask(IOrderInfoService orderInfoService, IWxPaymentService wxPaymentService) {
        this.orderInfoService = orderInfoService;
        this.wxPaymentService = wxPaymentService;
    }

    /**
     * 定时查询超时【 5min 】订单
     */
    @Scheduled(cron = "0/15 * * * * ?")
    public void findTimeOutOrderTask() throws IOException {
        log.info("orderConfirm 被执行......");
        List<OrderInfo> timeOutOrders = orderInfoService.findTimeOutOrders(5);
        for (OrderInfo timeOutOrder : timeOutOrders) {
            // 核实订单状态
            wxPaymentService.orderStatusConfirm(timeOutOrder.getOrderNo());
        }
    }

}
