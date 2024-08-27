//package com.itbaizhan.controller;
//
//import com.itbaizhan.IPaymentService;
//import org.apache.dubbo.config.annotation.DubboReference;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @version v1.0
// * @author OldGj 2024/04/23
// * @apiNote 订单控制层
// */
//@RestController
//public class OrderController {
//
//
//    /*
//        @DubboReference：
//            1.标记服务引用：通过在服务消费者得字段或者方法上添加 @DubboReference，标记了对某个服务提供者的引用。
//            2.自动引用服务：dubbo框架自动得处理远程服务的引用。负载均衡，服务发现等
//            3.透明远程调用：dubbo框架自动处理远程调用的过程。将请求发送给服务提供者，把结果返回给服务消费者
//            4.提供配置选项：超时时间，重试次数，负载均衡等。
//     */
//    @DubboReference
//    private IPaymentService paymentService;
//
//    @GetMapping("/getOrder")
//    public String getOrder() {
//        return paymentService.payment("2");
//    }
//}
