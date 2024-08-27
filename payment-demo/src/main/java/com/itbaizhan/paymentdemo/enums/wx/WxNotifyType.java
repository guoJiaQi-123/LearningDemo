package com.itbaizhan.paymentdemo.enums.wx;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @version v1.0
 * @author OldGj 2024/04/18
 * @apiNote 微信通知回调路径枚举
 */
@Getter
@AllArgsConstructor
public enum WxNotifyType {

    /**
     * 微信支付成功通知回调接口
     */
    NATIVE_NOTIFY("/api/wx-pay/native/notify"),

    /**
     * 微信退款成功同志回调接口
     */
    REFUND_NOTIFY("/api/wx-pay/refunds/notify");
    private final String type;
}
