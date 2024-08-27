package com.itbaizhan.paymentdemo.controller.dto;

import lombok.Data;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote 订单数据传输对象
 */
@Data
public class OrderInfoDTO {
    /**
     * 订单标题
     */
    private String title;
    /**
     * 订单金额(分)
     */
    private Integer totalFee;
}
