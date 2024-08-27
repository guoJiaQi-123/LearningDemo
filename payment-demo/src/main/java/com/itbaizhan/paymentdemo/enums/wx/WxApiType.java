package com.itbaizhan.paymentdemo.enums.wx;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 微信Native下单请求路径枚举
 */
@AllArgsConstructor
@Getter
public enum WxApiType {

    /**
     * Native下单
     */
    NATIVE_PAY("/v3/pay/transactions/native"),
    /**
     * 查询订单 [ 商户订单号查询订单 ]
     */
    ORDER_QUERY_BY_NO("/v3/pay/transactions/out-trade-no/%s"),

    /**
     * 关闭订单
     */
    CLOSE_ORDER_BY_NO("/v3/pay/transactions/out-trade-no/%s/close"),

    /**
     * 申请退款
     */
    DOMESTIC_REFUNDS("/v3/refund/domestic/refunds"),

    /**
     * 查询单笔退款
     */
    DOMESTIC_REFUNDS_QUERY("/v3/refund/domestic/refunds/%s");


    /**
     * 类型
     */
    private final String type;
}