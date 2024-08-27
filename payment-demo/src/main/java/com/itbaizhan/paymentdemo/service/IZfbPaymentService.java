package com.itbaizhan.paymentdemo.service;


import com.alipay.api.AlipayApiException;
import com.itbaizhan.paymentdemo.ov.BaseResult;
import com.itbaizhan.paymentdemo.ov.PayInfoVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @version v1.0
 * @author OldGj 2024/04/20
 * @apiNote 支付宝接口
 */
public interface IZfbPaymentService {

    /**
     * 支付宝下单接口
     * @param orderNo 订单编号
     * @return 支付返回信息 [<br></br>
     *                      qr_code：当前预下单请求生成的二维码码串<br></br>
     *                      out_trade_no：商户的订单号<br></br>
     *                     ]
     */
    BaseResult<PayInfoVO> pcPay(String orderNo);


    /**
     * 支付成功后修改支付订单状态
     * @param request 回调请求
     */
    void updateOrderStatus(HttpServletRequest request);


    /**
     * 支付宝退款
     * @param orderNo 订单编号
     * @param reason 退款原因
     */
    void refund(String orderNo,String reason) throws AlipayApiException;


    /**
     * 查询交易状态
     * @param orderNo 订单编号
     * @return 交易状态
     */
    String queryOrder(String orderNo) throws Exception;
}
