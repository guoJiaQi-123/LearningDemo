package com.itbaizhan.paymentdemo.ov;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 响应码枚举
 */
@AllArgsConstructor
@Getter
public enum CodeEnum {

    // 正常
    SUCCESS(200, "SUCCESS"),
    // 系统异常
    SYSTEM_ERROR(500, "系统异常"),
    // 订单异常
    ORDER_ERROR(600, "订单异常"),
    // 支付异常
    PAYMENT_ERROR(601, "支付系统异常");

    private final Integer code;

    private final String message;
}
