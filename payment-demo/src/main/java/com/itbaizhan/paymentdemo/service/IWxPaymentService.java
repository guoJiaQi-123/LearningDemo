package com.itbaizhan.paymentdemo.service;

import com.itbaizhan.paymentdemo.ov.BaseResult;
import com.itbaizhan.paymentdemo.ov.PayInfoVO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote 微信支付业务层
 */
public interface IWxPaymentService {

    /**
     * 微信native支付
     * @param orderNo 订单编号
     */
    BaseResult<PayInfoVO> nativePay(String orderNo) throws IOException;

    /**
     * 修改支付状态
     * @param bodyMap  请求体中的数据
     */
    void updateOrderStatus(Map<String, Object> bodyMap);


    /**
     * 商户订单号查询订单
     *
     * @param orderNo 订单编号
     * @return 订单信息
     */
    String queryOrder(String orderNo) throws IOException;


    /**
     * 根据订单ID核实订单状态
     * @param orderNo 订单编号
     */
    void orderStatusConfirm(String orderNo) throws IOException;

    /**
     * 取消订单
     * @param orderNo 订单编号
     */
    void cancelOrder(String orderNo) throws IOException;

    /**
     * 根据订单编号退款
     * @param orderNo 订单编号
     * @param reason 退款原因
     */
    void refund(String orderNo, String reason) throws IOException;


    /**
     * 修改退款单数据
     * @param bodyMap 退款通知参数
     */
    void updateRefundStatus(HashMap<String, Object> bodyMap);
}
