package com.itbaizhan.paymentdemo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付类型枚举  [ 微信支付   -   支付宝支付 ]
 */
@Getter
@AllArgsConstructor
public enum PayType {


    /**
     * 微信
     */
    WXPAY("微信"),


    /**
     * 支付宝
     */
    ALIPAY("支付宝");

    /**
     * 类型
     */
    private final String type;


}
