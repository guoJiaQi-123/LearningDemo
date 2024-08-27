package com.itbaizhan;

/**
 * @version v1.0
 * @apiNote 支付接口
 * @author OldGj 2024/04/23
 */
public interface IPaymentService {

    /**
     * 根据订单ID支付
     * @param id 订单ID
     */
    String payment(String id);
}
