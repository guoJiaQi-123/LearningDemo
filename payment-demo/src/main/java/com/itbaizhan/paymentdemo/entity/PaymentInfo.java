package com.itbaizhan.paymentdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote 支付记录实体类
 */
@Getter
@Setter
@ToString
@TableName("payment_info")
public class PaymentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 支付记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户订单编号
     */
    private String orderNo;

    /**
     * 支付系统交易编号
     */
    private String transactionId;

    /**
     * 支付类型
     */
    private String paymentType;

    /**
     * 交易类型
     */
    private String tradeType;

    /**
     * 交易状态
     */
    private String tradeState;

    /**
     * 支付金额(分)
     */
    private Integer payerTotal;

    /**
     * 通知参数
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
