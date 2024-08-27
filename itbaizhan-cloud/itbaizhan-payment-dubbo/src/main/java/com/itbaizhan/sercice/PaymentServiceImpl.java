package com.itbaizhan.sercice;

import com.itbaizhan.IPaymentService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @version v1.0
 * @author OldGj 2024/04/23
 * @apiNote 支付业务层实现类
 * @DubboService 注解用来标记一个类或接口作为dubbo服务提供者。并将其发布为dubbo服务。
 *               1.标记服务提供者，类上或者接口上
 *               2.自动暴露服务，在应用启动时候dubbo自动处理服务发布过程。【协议选择，端口绑定，注册中心注册等】
 *               3.透明远程调用，无需关心底层的远程调用的通信细节
 *               4.提供配置选项，超时时间。最大并发数，负载均衡配置
 */
@DubboService
public class PaymentServiceImpl implements IPaymentService {

    /**
     * 根据订单ID支付
     * @param id 订单ID
     */
    @Override
    public String payment(String id) {
        return " payment success ";
    }
}
