package com.itbaizhan.paymentdemo.enums.zfb;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @version v1.0
 * @author OldGj 2024/04/18
 * @apiNote 支付宝通知回调路径枚举
 */
@Getter
@AllArgsConstructor
public enum ZfbNotifyType {

    /**
     * 支付宝支付成功通知回调接口
     */
    PC_NOTIFY("/api/zfb-pay/pcPay/notify"),

    /**
     * 支付宝退款成功同志回调接口
     */
    REFUND_NOTIFY("/api/zfb-pay/refunds/notify");

    private final String type;
}
