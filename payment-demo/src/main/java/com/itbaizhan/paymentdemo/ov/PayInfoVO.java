package com.itbaizhan.paymentdemo.ov;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote 支付结果信息封装对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayInfoVO {
    // codeUrl 二维码链接
    private String codeUrl;
    // 订单的唯一编号
    private String orderNo;

}
